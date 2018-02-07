package org.usfirst.frc.team5263.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.RobotMap;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;


/**
 *
 */
public class Rotation extends Command {

	double current;
	double difference;
	double angle;
	
	boolean isFinished = false;

	public Rotation(double angle) {
		requires(Robot.myDrive);
		setTimeout(.5);
		this.angle = angle;
		
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

	}



	// Called just before this Command runs the first time
	protected void initialize() {
	DriveTrain.reset();
	isFinished = false;
	}

	// Positive is to the right and negative is to the left
	

	// Called repeatedly when this Command is scheduled to run
	protected void execute() { 
		current = DriveTrain.getRotation();
		difference = angle - current;
		if(difference > 0){
			// Method below means turn right
			DriveTrain.drive(.4,-.4);
		}
		if(difference < 0){
			// Method below means turn left
			DriveTrain.drive(-.4,.4);
			
		}
		if(Math.abs(difference) < 5){ 
			DriveTrain.drive(0, 0);
			isFinished = true;
		}
		SmartDashboard.putNumber("gyro: ", DriveTrain.getRotation());

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
