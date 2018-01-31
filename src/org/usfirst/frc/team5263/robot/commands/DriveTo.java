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
	public static double doNotRun;
	
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
    	difference = encoderTarget - currentEncoderValue;
    	
    	if(counter < 50 && doNotRun == 0) {
    	DriveTrain.myRobot.tankDrive(power, power);
    	}else {
    		doNotRun = 1;
    		counter = 0;
    	}
    	//Find the difference of where we are and were we want to be
    	difference = encoderTarget - currentEncoderValue;
    	
    	if(difference > 20) {
    		if(counter < 20 && doNotRun == 1) {
    			DriveTrain.myRobot.tankDrive(power, power);
    		}else {
    			doNotRun = 2;
    			counter = 0;
    		}
    	}else {
    		if(difference < 20) {
    			System.out.println("You GOOOD");
    		}else {
    			System.out.println("You probably good!!!! ");
    		}
    	}
    	
    	counter++;
    }
    
    public static boolean closeEnough() {
    	
    	if(difference < encoderTarget) {
    		
    	}
    	
    	return true;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive(3, .5);
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
