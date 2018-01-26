package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriverOperated extends Command {

    public DriverOperated() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.myDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftStickSpeed = Robot.m_oi.main.getRawAxis(1);
    	double rightStickSpeed = Robot.m_oi.main.getRawAxis(5);
    	
    	/*
    	 * Axis 0 = Left Stick X
    	 * Axis 1 = Left Stick Y 
    	 * Axis 4 - Right Stick X 
    	 * Axis 5 - Right Stick Y
    	 */
    	
    	
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
