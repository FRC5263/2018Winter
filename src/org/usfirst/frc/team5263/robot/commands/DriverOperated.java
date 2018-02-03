package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriverOperated extends Command {

    public DriverOperated() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.myDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftStickSpeed = Robot.m_oi.main.getRawAxis(1);
    	double rightStickSpeed = Robot.m_oi.main.getRawAxis(5);
    	
    	/*
    	 * Axis 0 = Left Stick X
    	 * Axis 1 = Left Stick Y 
    	 * Axis 4 - Right Stick X 
    	 * Axis 5 - Right Stick Y
    	 */
    	
    	DriveTrain.Drive(-leftStickSpeed, -rightStickSpeed);
    	
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
