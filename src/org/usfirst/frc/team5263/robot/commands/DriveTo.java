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
	private double leftCorrection = 1.0;
	private double rightCorrection = 1.0;

	double driveDistanceFeet;
	double power;

	public DriveTo(double driveDistanceFeet, double power) {
		requires(Robot.myDrive);

		this.driveDistanceFeet = driveDistanceFeet;
		this.power = power;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		DriveTrain.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		SmartDashboard.putNumber("encoder Target:", encoderTarget);
		SmartDashboard.putNumber("Left Encoder Inches", DriveTrain.getLeftEncoderInches());
		SmartDashboard.putNumber("Right Encoder Inches", DriveTrain.getRightEncoderInches());
		SmartDashboard.putNumber("Direction", direction);

		//Converts Feet to inches values
		encoderTarget = driveDistanceFeet * 12;
		// if target is negative, target is negative

		if(encoderTarget >= 0) {
			direction = 1.0;
		} else {
			direction = -1.0;
		}
		//then direction is negative

		encoderTarget = direction * (driveDistanceFeet * 12);
		//-1 * negative = positive

		//DriveTrain.getLeftEncoder()
		if(DriveTrain.getLeftEncoderInches()*direction < encoderTarget) {
			DriveTrain.drive((direction * power) + leftCorrection, (direction * power) + rightCorrection);
		}else {
			DriveTrain.drive(0.0, 0.0);
			isFinished = true;
		}

		leftCorrection = -1 * ((DriveTrain.getLeftEncoderInches() - DriveTrain.getRightEncoderInches()) / 10);
		rightCorrection = 1 * ((DriveTrain.getLeftEncoderInches() - DriveTrain.getRightEncoderInches()) / 10);

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
