package org.usfirst.frc.team5263.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5263.robot.OI;
import org.usfirst.frc.team5263.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
	DifferentialDrive robotDrive = RobotMap.robotDrive;
	
	// Get all of the encoders from OI
	public static double LeftEncoder = RobotMap.getLeftEncoder();
	public static double RightEncoder = RobotMap.getRightEncoder();
	
    public void initDefaultCommand() {
        
    }
    
    public static void EncoderDrive(double DriveFeet, double power) {
    	SmartDashboard.getNumber("Left Encoder", LeftEncoder);
    	SmartDashboard.getNumber("Right Encoder", RightEncoder);
    	
    	System.out.println("Left Encoder: " + LeftEncoder);
    	System.out.println("Right Encoder: " + RightEncoder);
    	
    	
    	
    	
    }
    
    public void drive(double leftSpeed, double rightSpeed, double time) {
    	robotDrive.tankDrive(leftSpeed, rightSpeed);
    }
}

