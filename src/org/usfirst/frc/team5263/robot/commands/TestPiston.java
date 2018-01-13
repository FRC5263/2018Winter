package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestPiston extends Command {

    public TestPiston() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.myPneumatics);
    	setTimeout(.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.myPneumatics.off();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.myPneumatics.forward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.myPneumatics.off();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
