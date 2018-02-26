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

	private double camAxisXRotation = 1.0;
	private double camAxisYRotation = 1.0;
	
	private double speedFactor = .65;
	
    public DriverOperated() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.myDrive);
    	requires(Robot.myVision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	    Vision.setCamAxisX(90);
	    Vision.setCamAxisY(180);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean ButtonA = Robot.m_oi.getButtonMain(ButtonName.A);
    	boolean ButtonB = Robot.m_oi.getButtonMain(ButtonName.B);
    	boolean ButtonX = Robot.m_oi.getButtonMain(ButtonName.X);
    	boolean ButtonY = Robot.m_oi.getButtonMain(ButtonName.Y);
    	
    	double leftStickY = Robot.m_oi.driverGamepad.getRawAxis(1) * -1; 
    	double rightStickX = Robot.m_oi.driverGamepad.getRawAxis(4);
    	DriveTrain.sharedInstance().arcadeDrive(leftStickY * speedFactor, rightStickX * speedFactor);
    	
    	if(ButtonX) {
    		System.out.println("Full Speed"); 
    		speedFactor = 1;
    	}else if(ButtonB){
    		System.out.println("65%");
    		speedFactor = .65;
    	}
    	
    	if(ButtonA){
    		CubeIntake.liftMotor(.5);
    	}else if(ButtonY){
    		CubeIntake.liftMotor(-.5);
    	}
    	/*
    	 * Axis 0 = Left Stick X
    	 * Axis 1 = Left Stick Y 
    	 * Axis 4 - Right Stick X 
    	 * Axis 5 - Right Stick Y
    	 */
    	
    	
    	double driveSpeed = 1;
    	double rightTrigger = Robot.m_oi.operatorGamepad.getRawAxis(3) * driveSpeed;
    	double leftTrigger = Robot.m_oi.operatorGamepad.getRawAxis(2) * driveSpeed;
    	
    	//Check that both triggers aren't being pushed
    	if(rightTrigger > 0.1 && leftTrigger > 0.1) {
    		CubeIntake.driveMotors(0.0);
    	}else {
    		//When the rightTrigger is held the CubeIntake will push the cube out
    		if(rightTrigger > .1) {
    			//Take the power of the trigger
    			//set that to the speed of the CubeIntake Motors
    			CubeIntake.driveMotors(rightTrigger);
    		}else if(leftTrigger > .1) {
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
    			BucketArm.driveMotor(-0.4);
    		}else if(yButton) {
    			BucketArm.driveMotor(1);
    		}else {
    			BucketArm.driveMotor(0.0);
    		}
    	}
    	
    	
    	switch(Robot.m_oi.operatorGamepad.getPOV()) {
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
    		break;
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
    	if(camAxisXRotation < 0.99) {
    		camAxisXRotation += 0.01;   
    	}
    }
    
    private void increaseYAxis() {
    	if(camAxisYRotation < 0.99) {
    		camAxisYRotation += 0.01;
    	}
    }
    
    private void decreaseXAxis() {
    	if(camAxisXRotation > 0.01) {
    		camAxisXRotation -= 0.01;
    		
    				}
    }

    private void decreaseYAxis() {
    	if(camAxisYRotation > 0.01) {
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
