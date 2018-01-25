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
	
    public DriveTo() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.myDrive);
        setTimeout(.5);
     
    }
    
    
    // Drive a specific distance
    public static void drive(double driveDistanceFeet, double power) {
    	double encoderTarget = (driveDistanceFeet * 12) / (Math.PI * 6) * 1440 / 4;
    	
    	System.out.println(encoderTarget);
    	
    	//RobotMap.myRobot.tankDrive(leftspeed, rightSpeed);
    	
    	counter++;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive(.5, .5);
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
