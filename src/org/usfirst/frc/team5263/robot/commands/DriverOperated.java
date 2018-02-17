package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.OI.ButtonName;
import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.subsystems.BucketArm;
import org.usfirst.frc.team5263.robot.subsystems.CubeIntake;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5263.robot.subsystems.Vision;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriverOperated extends Command {

	private double camAxisXRotation = 0.5;
	private double camAxisYRotation = 0.5;
	
    public DriverOperated() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.myDrive);
    	requires(Robot.myVision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	    Vision.setCamAxisX(0.5);
	    Vision.setCamAxisY(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftStickSpeed = Robot.m_oi.main.getRawAxis(1);
    	double rightStickSpeed = Robot.m_oi.main.getRawAxis(5);
    	Robot.m_oi.main.getPOV();
    	/*
    	 * Axis 0 = Left Stick X
    	 * Axis 1 = Left Stick Y 
    	 * Axis 4 - Right Stick X 
    	 * Axis 5 - Right Stick Y
    	 */
    	DriveTrain.sharedInstance().drive(-leftStickSpeed, -rightStickSpeed);
    	
    	double rightTrigger = Robot.m_oi.main.getRawAxis(3);
    	double leftTrigger = Robot.m_oi.main.getRawAxis(2);
    	
    	//Check that both triggers aren't being pushed
    	if(rightTrigger != 0 && leftTrigger != 0) {
    		CubeIntake.driveMotors(0.0);
    	}else {
    		//When the rightTrigger is held the CubeIntake will push the cube out
    		if(rightTrigger != 0) {
    			//Take the power of the trigger
    			//set that to the speed of the CubeIntake Motors
    			CubeIntake.driveMotors(rightTrigger);
    		}else {
    			//Do nothing
    			CubeIntake.driveMotors(0.0);
    		}
    		//When the leftTrigger is held the CubeIntake will pull the cube in
    		if(leftTrigger != 0) {
    			//Take the power of the trigger
    			//set that to the speed of the CubeIntake Motors
    			//Made negative so the motors pull in
    			CubeIntake.driveMotors(-leftTrigger);
    		}else {
    			//Do nothing one last time
    			CubeIntake.driveMotors(0.0);
    		}
    	}
    	
    	//FLIP BUCKET
    	boolean aButton = Robot.m_oi.getButton(ButtonName.A);
    	boolean yButton = Robot.m_oi.getButton(ButtonName.Y);
    	
    	if(aButton & yButton) {
    		//We don't want to do anything
    		BucketArm.driveMotor(0.0);
    	}else {
    		if(aButton) {
    			BucketArm.driveMotor(1.0);
    		}else if(yButton) {
    			BucketArm.driveMotor(-1.0);
    		}else {
    			BucketArm.driveMotor(0.0);
    		}
    	}
    	
    	
    	switch(Robot.m_oi.main.getPOV()) {
    	case 0: 
    		increaseYAxis();
    	break;
    	case 45: 
    		increaseYAxis();
    		increaseXAxis();
    	break;
    	case 90:
    		increaseXAxis();
    		break;
    	case 135:
    		decreaseYAxis();
    		increaseXAxis();
    		break;
    	case 180:
    		decreaseYAxis();
    		break;
    	case 225:
    		decreaseXAxis();
    		decreaseYAxis();
    		break;
    	case 270:
    		decreaseXAxis();
    		break;
    	case 315:
    		decreaseXAxis();
    		increaseYAxis();
    	}
    	
    	Vision.setCamAxisX(camAxisXRotation);
    	Vision.setCamAxisY(camAxisYRotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    private void increaseXAxis() {
    	if(camAxisXRotation < 1.0) {
    		camAxisXRotation += 0.01;   
    	}
    }
    
    private void increaseYAxis() {
    	if(camAxisYRotation < 1.0) {
    		camAxisYRotation += 0.01;
    	}
    }
    
    private void decreaseXAxis() {
    	if(camAxisXRotation > 0.01) {
    		camAxisXRotation -= 0.01;
    	}
    }

    private void decreaseYAxis() {
    	if(camAxisYRotation > 0.1) {
    		camAxisYRotation -= 0.01;
    	}
    }
    
    //Push the cube in
//    private void cubeOut() {
//    	CubeIntake.driveMotors(.5);
//    }
//    
//    private void cubeIn() {
//    	CubeIntake.driveMotors(-0.5);
//    }
    
    //
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
