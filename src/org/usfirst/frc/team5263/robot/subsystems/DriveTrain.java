package org.usfirst.frc.team5263.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5263.robot.OI;
import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	// Get all of the encoders from OI
	public static double LeftEncoder = RobotMap.getLeftEncoder();
	public static double RightEncoder = RobotMap.getRightEncoder();
	
	public static double feet;
	
    public void initDefaultCommand() {
        
    }
    
    public static void EncoderDrive(double DriveFeet, double power) {
    	SmartDashboard.getNumber("Left Encoder", LeftEncoder);
    	SmartDashboard.getNumber("Right Encoder", RightEncoder);
    	
    	System.out.println("Left Encoder: " + LeftEncoder);
    	System.out.println("Right Encoder: " + RightEncoder);
    	System.out.println("Drive feet and such"+ DriveFeet);
    	System.out.println("Power to drive and such"+ power);
    }
}

