package org.usfirst.frc.team5263.robot.commands;

import org.usfirst.frc.team5263.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToShape extends CommandGroup {

	double turnPower;
	double drivePower;
	double degrees;
	double feet;
    public DriveToShape(double degrees, double turnPower, double feet, double drivePower) {
    	
    	this.drivePower = drivePower;
    	this.turnPower = turnPower;
    	this.degrees = degrees;
    	this.feet = feet;
    	
    	addSequential(new DriveTo(feet, drivePower));
    	addSequential(new Rotation(degrees, turnPower));
    	
    	
    	addSequential(new DriveTo(feet, drivePower));
    	addSequential(new Rotation(degrees, turnPower));
    	
    	addSequential(new DriveTo(feet, drivePower));
    	addSequential(new Rotation(degrees, turnPower));
    	
    	addSequential(new DriveTo(feet, drivePower));
    	addSequential(new Rotation(degrees, turnPower));
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
