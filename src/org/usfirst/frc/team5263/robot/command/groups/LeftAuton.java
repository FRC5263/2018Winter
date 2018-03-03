package org.usfirst.frc.team5263.robot.command.groups;

import org.usfirst.frc.team5263.robot.commands.DriveTo;
import org.usfirst.frc.team5263.robot.commands.FlipBucket;
import org.usfirst.frc.team5263.robot.commands.Lift;
import org.usfirst.frc.team5263.robot.commands.RotatePID;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAuton extends CommandGroup {

    public LeftAuton() {
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	if(gameData.length() > 0) {
    		if(gameData.charAt(0) == 'L'){
    			System.out.println("Run Left Auto");
    			
    			addSequential(new DriveTo(12, .4, 0));
    			addSequential(new RotatePID(90));
    			
    			addSequential(new DriveTo(1, .4, 90));
    			addSequential(new Lift(-0.4, 0.5));
    			addSequential(new FlipBucket());
    			//This function runs if the data is for the right side
    		}else {
    			System.out.println("Run Right Auto");
    			
    			addSequential(new DriveTo(16.5, .4, 0));
    			addSequential(new RotatePID(90));
    			
    			addSequential(new DriveTo(12.75, .4, 90));
    			addSequential(new RotatePID(180));
    			addSequential(new DriveTo(0.5, .4, 180));
    			
    			addSequential(new Lift(-0.4, 0.5));
    			addSequential(new FlipBucket());	
    			}
    	}
    }
}    
   
