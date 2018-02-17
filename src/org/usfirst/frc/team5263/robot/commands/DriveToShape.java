package org.usfirst.frc.team5263.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToShape extends CommandGroup {

	double turnPower;
	double drivePower;
	double degrees;
	double feet;
    public DriveToShape(double turnPower, double drivePower) {
    	
    	this.drivePower = drivePower;
    	this.turnPower = turnPower;
    	
    	addSequential(new DriveTo(4, drivePower, 0));
    	addSequential(new Wait(1));
    	addSequential(new Rotation(90, turnPower));
    	
    	addSequential(new DriveTo(3, drivePower, 90));
    	addSequential(new Wait(1));
    	addSequential(new Rotation(0, turnPower));
    	
    	addSequential(new DriveTo(6, drivePower, 0));
    	addSequential(new Wait(1));
    	addSequential(new Rotation(-90, turnPower));
    	
    	addSequential(new DriveTo(4, drivePower, -90));
    	addSequential(new Wait(1));
    	addSequential(new Rotation(0, turnPower));
    	
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
