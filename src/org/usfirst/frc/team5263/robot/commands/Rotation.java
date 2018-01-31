package org.usfirst.frc.team5263.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;


/**
 *
 */
public class Rotation extends Command {
	
	double current;
	double difference;
	
	public Rotation() {
		requires(Robot.myDrive);
		setTimeout(.5);
		
		ADXRS450_Gyro gyro = DriveTrain.gyro;
		Encoder LeftEncoder = DriveTrain.LeftEncoder;
		Encoder RightEncoder = DriveTrain.RightEncoder;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		
		LeftEncoder.setPIDSourceType(PIDSourceType.kRate);
    }
	
	public double getGyroAngle() {
		
		double gyroAngle = DriveTrain.gyro.getAngle();
		return gyroAngle * (360.0/325.0); //(360.0/330.0); //327 on comp bot, 340 on test bot
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    public boolean Rotate(double degrees) {
    	
    	current = getGyroAngle();
    	
    	difference = current - degrees;
    	
    	
    	return true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    SmartDashboard.putNumber("gyro: ", getGyroAngle());
    
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