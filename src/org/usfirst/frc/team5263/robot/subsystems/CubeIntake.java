package org.usfirst.frc.team5263.robot.subsystems;

import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {

	//objects
	private static final Victor intakeMotorLeft = new Victor (RobotMap.intakeMotorLeftChannel);
	private static final Victor intakeMotorRight = new Victor (RobotMap.intakeMotorRightChannel);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void driveMotors(double power) {
    	intakeMotorLeft.set(power);
    	intakeMotorRight.set(power);
    }
    
}

