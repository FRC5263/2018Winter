package org.usfirst.frc.team5263.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static Servo camAxisX = new Servo(2);
	private static Servo camAxisY = new Servo(3);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void setCamAxisX(double rotation) {
    	camAxisX.set(rotation);
    }
    
    public static void setCamAxisY(double rotation) {
    	camAxisY.set(-rotation);
    }
    
}