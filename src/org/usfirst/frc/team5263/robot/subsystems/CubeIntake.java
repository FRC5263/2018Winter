package org.usfirst.frc.team5263.robot.subsystems;

import org.usfirst.frc.team5263.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntake extends Subsystem {

	//objects
	private static final Victor intakeMotorLeft = new Victor (RobotMap.intakeMotorLeftChannel);
	private static final Victor intakeMotorRight = new Victor (RobotMap.intakeMotorRightChannel);
	private static final Talon cubeIntakeLift = new Talon(RobotMap.cubeIntakeLiftChannel);
	
	
	private static final Encoder liftEncoder = new Encoder(RobotMap.cubeIntakeLiftEncoderA,RobotMap.cubeIntakeLiftEncoderB); 
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    //Positive - push the cube out
    //Negative - pull the cube in
    public static void driveMotors(double power) {
    	intakeMotorLeft.set(power);
    	intakeMotorRight.set(power);
    }
    
    public static void liftMotor(double power){
    	cubeIntakeLift.set(power);
    }
    
}

