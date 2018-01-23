package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTo extends Command {

    public DriveTo() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.myDrive);
        setTimeout(.5);
    }
    
    // Drive a specific distance
    public static void Drive(double leftspeed, double rightSpeed) {
    	RobotMap.myRobot.tankDrive(leftspeed, rightSpeed);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
