package org.usfirst.frc.team5263.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;

import com.kauailabs.navx.frc.AHRS;
/**
 *
 */
public class DriveTrain extends Subsystem {
	
	//objects
	private static DifferentialDrive myRobot = new DifferentialDrive(RobotMap.leftMotor, RobotMap.rightMotor);
	private static Encoder LeftEncoder = RobotMap.LeftEncoder;
	private static Encoder RightEncoder = RobotMap.RightEncoder;
	
	private final static int HZ = 60;
	public static AHRS ahrs = new AHRS(SPI.Port.kMXP, (byte)HZ);
	private static Ultrasonic sonic = new Ultrasonic(4,5); //input, output on the sensor
	
	//constants
	private final static double wheelDiameterInches = 6.0;
	private final static double encoderClicksPerRevolution = 360;
	private final static double ultrasonicOffset = 3; //inches the ultrasonic is mounted from the front of the robot
	
	public DriveTrain() {
		sonic.setAutomaticMode(true);
	}
	
    public void initDefaultCommand() {
        
    }
    
    public static double getRotation() {
    	return ahrs.getAngle();
    }
    
    public static double getLeftEncoder() {
		return (double) -RobotMap.LeftEncoder.get();
	}
    
	public static double getRightEncoder() {
		 return (double) -RobotMap.RightEncoder.get();
	}
	
	/*
	 *                  1 revolution    pi * wheel diameter inches
	 * encoder clicks * ------------ * ---------------------------- = inches traveled
	 *                    # clicks             1 revolution
	 */
	public static double getLeftEncoderInches() {
		return getLeftEncoder() * (1 / encoderClicksPerRevolution) * (Math.PI * wheelDiameterInches);
	}
	
	public static double getRightEncoderInches() {
		return getRightEncoder() * (1 / encoderClicksPerRevolution) * (Math.PI * wheelDiameterInches);
	}
	
	public static void resetEncoders() {
		LeftEncoder.reset();
		RightEncoder.reset();
	}
	
	public static void drive(double leftPower, double rightPower) {
		myRobot.tankDrive(leftPower, rightPower);
	}
	
	public static void reset() {
		ahrs.reset();
	}
	
	public static double getSonicDistance() {
		return sonic.getRangeInches() - ultrasonicOffset;
	}
	
	public static void displayData() {
//		putAHRSOnDashboard();
		SmartDashboard.putNumber("Ultrasonic Distance in inches    ", getSonicDistance());
		SmartDashboard.putNumber("Left Encoder Distance in inches  ", getLeftEncoderInches());
		SmartDashboard.putNumber("Right Encoder Distance in inches ", getRightEncoderInches());
		SmartDashboard.putNumber("Gyroscopic angle in degrees      ", getRotation());
		
		double rate = HZ * (DriveTrain.ahrs.getRate());
		
		SmartDashboard.putNumber("PID rate", rate);
	}
	
	public static void putAHRSOnDashboard() {
		/* Display 6-axis Processed Angle Data                                      */
		SmartDashboard.putBoolean(  "IMU_Connected",        DriveTrain.ahrs.isConnected());
		SmartDashboard.putBoolean(  "IMU_IsCalibrating",    DriveTrain.ahrs.isCalibrating());
		SmartDashboard.putNumber(   "IMU_Yaw",              DriveTrain.ahrs.getYaw());
		SmartDashboard.putNumber(   "IMU_Pitch",            DriveTrain.ahrs.getPitch());
		SmartDashboard.putNumber(   "IMU_Roll",             DriveTrain.ahrs.getRoll());
		
		/* Display tilt-corrected, Magnetometer-based heading (requires             */
		/* magnetometer calibration to be useful)                                   */
		
		SmartDashboard.putNumber(   "IMU_CompassHeading",   DriveTrain.ahrs.getCompassHeading());
		
		/* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
		SmartDashboard.putNumber(   "IMU_FusedHeading",     DriveTrain.ahrs.getFusedHeading());
		
		/* These functions are compatible w/the WPI Gyro Class, providing a simple  */
		/* path for upgrading from the Kit-of-Parts gyro to the navx-MXP            */
		
		SmartDashboard.putNumber(   "IMU_TotalYaw",         DriveTrain.ahrs.getAngle());
		SmartDashboard.putNumber(   "IMU_YawRateDPS",       DriveTrain.ahrs.getRate());
		
		/* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
		
		SmartDashboard.putNumber(   "IMU_Accel_X",          DriveTrain.ahrs.getWorldLinearAccelX());
		SmartDashboard.putNumber(   "IMU_Accel_Y",          DriveTrain.ahrs.getWorldLinearAccelY());
		SmartDashboard.putBoolean(  "IMU_IsMoving",         DriveTrain.ahrs.isMoving());
		SmartDashboard.putBoolean(  "IMU_IsRotating",       DriveTrain.ahrs.isRotating());
		
		/* Display estimates of velocity/displacement.  Note that these values are  */
		/* not expected to be accurate enough for estimating robot position on a    */
		/* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
		/* of these errors due to single (velocity) integration and especially      */
		/* double (displacement) integration.                                       */
		
		SmartDashboard.putNumber(   "Velocity_X",           DriveTrain.ahrs.getVelocityX());
		SmartDashboard.putNumber(   "Velocity_Y",           DriveTrain.ahrs.getVelocityY());
		SmartDashboard.putNumber(   "Displacement_X",       DriveTrain.ahrs.getDisplacementX());
		SmartDashboard.putNumber(   "Displacement_Y",       DriveTrain.ahrs.getDisplacementY());
		
		/* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
		/* NOTE:  These values are not normally necessary, but are made available   */
		/* for advanced users.  Before using this data, please consider whether     */
		/* the processed data (see above) will suit your needs.                     */
		
		SmartDashboard.putNumber(   "RawGyro_X",            DriveTrain.ahrs.getRawGyroX());
		SmartDashboard.putNumber(   "RawGyro_Y",            DriveTrain.ahrs.getRawGyroY());
		SmartDashboard.putNumber(   "RawGyro_Z",            DriveTrain.ahrs.getRawGyroZ());
		SmartDashboard.putNumber(   "RawAccel_X",           DriveTrain.ahrs.getRawAccelX());
		SmartDashboard.putNumber(   "RawAccel_Y",           DriveTrain.ahrs.getRawAccelY());
		SmartDashboard.putNumber(   "RawAccel_Z",           DriveTrain.ahrs.getRawAccelZ());
		SmartDashboard.putNumber(   "RawMag_X",             DriveTrain.ahrs.getRawMagX());
		SmartDashboard.putNumber(   "RawMag_Y",             DriveTrain.ahrs.getRawMagY());
		SmartDashboard.putNumber(   "RawMag_Z",             DriveTrain.ahrs.getRawMagZ());
		SmartDashboard.putNumber(   "IMU_Temp_C",           DriveTrain.ahrs.getTempC());
		
		/* Omnimount Yaw Axis Information                                           */
		/* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
		AHRS.BoardYawAxis yaw_axis = DriveTrain.ahrs.getBoardYawAxis();
		SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
		SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
		
		/* Sensor Board Information                                                 */
		SmartDashboard.putString(   "FirmwareVersion",      DriveTrain.ahrs.getFirmwareVersion());
		
		/* Quaternion Data                                                          */
		/* Quaternions are fascinating, and are the most compact representation of  */
		/* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
		/* from the Quaternions.  If interested in motion processing, knowledge of  */
		/* Quaternions is highly recommended.                                       */
		SmartDashboard.putNumber(   "QuaternionW",          DriveTrain.ahrs.getQuaternionW());
		SmartDashboard.putNumber(   "QuaternionX",          DriveTrain.ahrs.getQuaternionX());
		SmartDashboard.putNumber(   "QuaternionY",          DriveTrain.ahrs.getQuaternionY());
		SmartDashboard.putNumber(   "QuaternionZ",          DriveTrain.ahrs.getQuaternionZ());
		
		/* Connectivity Debugging Support                                           */
		SmartDashboard.putNumber(   "IMU_Byte_Count",       DriveTrain.ahrs.getByteCount());
		SmartDashboard.putNumber( "IMU_Update_Count", DriveTrain.ahrs.getUpdateCount());
	}
}

