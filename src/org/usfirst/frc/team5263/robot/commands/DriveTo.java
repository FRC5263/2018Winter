package org.usfirst.frc.team5263.robot.commands;


import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.RobotMap;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTo extends Command {

	public static int counter = 0;
	public static Encoder leftEncoder = RobotMap.LeftEncoder;
	public static Encoder rightEncoder = RobotMap.RightEncoder;
	
	public static double encoderTarget;
	public static double currentEncoderValue;
	public static double difference;
	
    public DriveTo() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.myDrive);
        setTimeout(.5);
     
    }
    
    
    // Drive a specific distance
    //Takes the distance you want to drive and power
    //DONT USE ONE FOR POWER
    public static void drive(double driveDistanceFeet, double power) {
    	
    	//Converts Feet to Encoder values
    	encoderTarget = (driveDistanceFeet * 12) / (Math.PI * 6) * 1440 / 4;
    	
    	//Get the average of both encoders
    	currentEncoderValue = (
    			leftEncoder.getDistance() + rightEncoder.getDistance()
    			)/2;
    	System.out.println(currentEncoderValue);
    	
    	//Find the difference of where we are and were we want to be
    	difference = currentEncoderValue - encoderTarget;
    	
    	if(counter < 50) {
    	RobotMap.myRobot.tankDrive(power, power);
    	}else {
    		counter = 0;
    	}
    	
    	//Find the difference of where we are and were we want to be
    	difference = currentEncoderValue - encoderTarget;
    	
    	if(difference >= 20 ) {
    		if(counter < 25) {
    		RobotMap.myRobot.tankDrive(-(power), -(power));
    		}else {
    			counter = 0;
    		}
    	}else {
    		if(difference <= -20) {
    			if(counter < 25) {
    				RobotMap.myRobot.tankDrive(power, power);
    			}else {
    				counter = 0;
    			}
    		}else {
    			System.out.println("SOMETHING WENT VERY WRONG");
    		}
    	}
    	
    	counter++;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive(10, .5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
