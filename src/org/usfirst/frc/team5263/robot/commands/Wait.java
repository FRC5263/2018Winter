package org.usfirst.frc.team5263.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.lang.*;
import java.time.temporal.IsoFields;

/**
 *
 */
public class Wait extends Command {

	private static boolean isFinished = false;
	double waitSeconds;
	
    public Wait(double waitSeconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	this.waitSeconds = waitSeconds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isFinished = false;
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentTime = System.currentTimeMillis();
    	if (currentTime < waitSeconds){
    		//do nothing
    		SmartDashboard.putNumber("Waiting? ", currentTime);
    	}
    	if(currentTime > waitSeconds){
    		System.out.println("Done");
    		isFinished = true;
    	}
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
