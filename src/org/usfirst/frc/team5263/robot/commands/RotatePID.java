package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotatePID extends Command {

	PIDController turnController;
	AHRS ahrs;
	static final double kP = 0.03;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;

	static final double kToleranceDegrees = 2.0f;

	private double degrees;

	public RotatePID(double angle) {
		
		requires(Robot.myDrive);
		ahrs = DriveTrain.ahrs;
		
		turnController = new PIDController(kP, kI, kD, kF, ahrs,  new PIDOutput() {
			@Override
			public void pidWrite(double output) {
				DriveTrain.drive(output, -output);
			}
		});
		
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
        
        this.degrees = angle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turnController.setSetpoint(degrees);
		turnController.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return turnController.onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		turnController.disable();
		ahrs.reset(); //maybee
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
	
}
