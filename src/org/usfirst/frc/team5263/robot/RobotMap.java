/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5263.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//pwm channel variables
	private static final VictorSP  rightDriveChannel = new VictorSP(1);
	private static final VictorSP  leftDriveChannel = new VictorSP(0);
	
	//pneumatic channel variables
	private static final int pistonSolenoidForwardChannel = 0;
	private static final int pistonSolenoidReverseChannel = 1;
	
	//objects
	public static DoubleSolenoid pistonSolenoid = new DoubleSolenoid(RobotMap.pistonSolenoidForwardChannel, RobotMap.pistonSolenoidReverseChannel); //forward channel, reverse channel 
	public static DifferentialDrive robotDrive = new DifferentialDrive(leftDriveChannel, rightDriveChannel);
	
}
