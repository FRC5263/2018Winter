package org.usfirst.frc.team5263.robot.commands;


import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.RobotMap;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTo extends Command {

	
	private double encoderTarget;
	private double direction = 0;
	private boolean isFinished = false;
	
	public DriveTo() {
		requires(Robot.myDrive);
	}
	
    // Drive a specific distance
    //Takes the distance you want to drive and power
    //DONT USE ONE FOR POWER
    public void drive(double driveDistanceFeet, double power) {
    	
    	SmartDashboard.putNumber("encoder Target:", encoderTarget);
    	SmartDashboard.putNumber("Left Encoder Value", DriveTrain.getLeftEncoder());
    	SmartDashboard.putNumber("Right Encoder Value", DriveTrain.getRightEncoder());
    	SmartDashboard.putNumber("Direction", direction);
    	
    	//Converts Feet to Encoder values
    	encoderTarget = ((driveDistanceFeet * 12) / (Math.PI * 6) * 1440 / 4);
    	// if target is negative, target is negative
    	if(encoderTarget >= 0) {
    		direction = 1.0;
    	} else {
    		direction = -1.0;
    	}
    	// then direction is negative
    	encoderTarget = direction * ((driveDistanceFeet * 12) / (Math.PI * 6) * 1440 / 4);
    	//-1 * negative = positive
    	if(	(DriveTrain.getLeftEncoder()*direction) < encoderTarget	) {
    		DriveTrain.Drive(direction * power, direction * power);
    	} else {
    		isFinished = true;
    	}	
    	// encoder values will grow negatively, but multiply by negative direction for pos
    	// if pos growing enc values are less than high encoder target value, 
    	//power motors in the right direction, will eventually reach target and terminate
    	//command
    	
    	
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
    	
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
