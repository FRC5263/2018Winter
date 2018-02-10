package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5263.robot.subsystems.Vision;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	DriveTrain.drive(-leftStickSpeed, -rightStickSpeed);
    	
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
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
