package org.usfirst.frc.team5263.robot.subsystems;

import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	private static Encoder armEncoder = RobotMap.ArmEncoder;
	public static double getArmEncoderInches(){
		return 0;
	}
	private static Victor leftIntakeMotor = RobotMap.intakeMotorLeft;
	private static Victor rightIntakeMotor = RobotMap.intakeMotorRight;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

