package org.usfirst.frc.team5263.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;
/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public static DifferentialDrive myRobot = new DifferentialDrive(RobotMap.leftMotor, RobotMap.rightMotor);
	public static double feet;
	
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	public static Encoder LeftEncoder = RobotMap.LeftEncoder;
	public static Encoder RightEncoder = RobotMap.RightEncoder;
	public static AHRS ahrs = new AHRS(SPI.Port.kMXP); 
	
    public void initDefaultCommand() {
        
    }
    
    public static void EncoderDrive(double DriveFeet, double power) {
    	SmartDashboard.putNumber("Left Encoder: ", getLeftEncoder());
    	SmartDashboard.putNumber("Right Encoder", getRightEncoder());
    	
    	System.out.println("Left Encoder: " + getLeftEncoder());
    	System.out.println("Right Encoder: " + getRightEncoder());
    	System.out.println("Drive feet and such"+ DriveFeet);
    	System.out.println("Power to drive and such"+ power);
    }
    
    public static Double getLeftEncoder() {
		return (double) RobotMap.LeftEncoder.get();
	}
    
	public static Double getRightEncoder() {
		 return (double) RobotMap.RightEncoder.get();
	}
	
	public static void Drive(double leftPower, double rightPower) {
		myRobot.tankDrive(leftPower, rightPower);
	}
	
}

