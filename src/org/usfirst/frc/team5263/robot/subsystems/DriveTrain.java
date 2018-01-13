package org.usfirst.frc.team5263.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team5263.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
	DifferentialDrive robotDrive = RobotMap.robotDrive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double leftSpeed, double rightSpeed) {
    	robotDrive.tankDrive(leftSpeed, rightSpeed);
    }
}

