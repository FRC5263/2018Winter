package org.usfirst.frc.team5263.robot.subsystems;

import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BucketArm extends Subsystem {
	
	//objects
	private static Victor liftMotor = new Victor(RobotMap.liftMotorChannel);
	private static DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchChannel);
    
	//methods
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void driveMotor(double power) {
		liftMotor.set(power);
	}
	
	public boolean isLimitClosed() {
		return limitSwitch.get();
	}
    
    
}

