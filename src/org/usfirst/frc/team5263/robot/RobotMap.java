/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5263.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//DIO channel variables
	private static final int leftEncoderChannelA = 0;
	private static final int leftEncoderChannelB = 1;
	private static final int rightEncoderChannelA = 2;
	private static final int rightEncoderChannelB = 3;
	
    public static final int limitSwitchChannel = 0; // change;
	
	//PWM channel variables
    	//for drive train
	private static final int leftTalonMotorChannel = 0;
	private static final int rightTalonMotorChannel = 1;
		//for cube intake
	public static final int intakeMotorLeftChannel = 5;
	public static final int intakeMotorRightChannel = 6;
		//for bucket arm
	public static final int liftMotorChannel = 0; //change
	
	//objects
	public static Encoder LeftEncoder = new Encoder(leftEncoderChannelA, leftEncoderChannelB);
	public static Encoder RightEncoder = new Encoder(rightEncoderChannelA, rightEncoderChannelB);
	public static final Talon leftMotor = new Talon(leftTalonMotorChannel);
	public static final Talon rightMotor = new Talon(rightTalonMotorChannel);
}
