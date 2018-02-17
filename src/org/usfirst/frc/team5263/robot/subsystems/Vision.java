package org.usfirst.frc.team5263.robot.subsystems;

import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static Servo camAxisX = new Servo(RobotMap.cameraXServoChannel);
	private static Servo camAxisY = new Servo(RobotMap.cameraYServoChannel);
	
	@SuppressWarnings("deprecation")
	NetworkTable tables;
	
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