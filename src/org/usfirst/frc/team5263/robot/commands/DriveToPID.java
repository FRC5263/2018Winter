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
public class DriveToPID extends Command {

	private double encoderTarget;
	private double direction = 0;
	private boolean isFinished = false;
	private double leftCorrection = 0.0;
	private double rightCorrection = 0.0;
	private boolean driveByAngle = false;
	private double initialAngle;
	double driveDistanceFeet;
	double power;

	public DriveToPID(double driveDistanceFeet, double power, double angle) {
		requires(Robot.myDrive);
		this.driveDistanceFeet = driveDistanceFeet;
		this.power = power;
		this.initialAngle = angle;
		this.driveByAngle = true;
	}
	public DriveToPID(double driveDistanceFeet, double power) {
		requires(Robot.myDrive);
		this.driveDistanceFeet = driveDistanceFeet;
		this.power = power;
		this.driveByAngle = false;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		DriveTrain.resetEncoders();
		isFinished = false;
		if(!driveByAngle) {
			initialAngle = DriveTrain.getRotation();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

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

//		leftCorrection = -1 * ((DriveTrain.getLeftEncoderInches() - DriveTrain.getRightEncoderInches()) / 10);
//		rightCorrection = 1 * ((DriveTrain.getLeftEncoderInches() - DriveTrain.getRightEncoderInches()) / 10);
		
		leftCorrection = -1 * ((DriveTrain.getRotation() - initialAngle) / 100) ;
		rightCorrection = 1 * ((DriveTrain.getRotation() - initialAngle) / 100) ;


	}
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println("DriveTo ran");
		
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		isFinished = false;
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}