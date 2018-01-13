package org.usfirst.frc.team5263.robot.subsystems;

import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid pistonSolenoid = RobotMap.pistonSolenoid;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void off() {
    	pistonSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    
    public void forward() {
    	pistonSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse() {
    	pistonSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    
}

