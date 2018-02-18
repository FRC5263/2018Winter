package org.usfirst.frc.team5263.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchAuton extends CommandGroup {

    public SwitchAuton() {
    	String gameData;
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	//This function runs if the field data is for the left side
    	if(gameData.length() > 0) {
    		if(gameData.charAt(0) == 'L'){
    			System.out.println("Run Left Auto");
    			
    			//This function runs if the data is for the right side
    		}else if(gameData.charAt(0) == 'R'){
    			System.out.println("Run Right Auto");
    			
    		}else{
    			System.out.println("Something went mega wrong");
    		}
    	}	
    }
}
