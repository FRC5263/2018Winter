package org.usfirst.frc.team5263.robot.command.groups;

import org.usfirst.frc.team5263.robot.commands.DriveTo;
import org.usfirst.frc.team5263.robot.commands.FlipBucket;
import org.usfirst.frc.team5263.robot.commands.RotatePID;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchAuton extends CommandGroup {

	private String LRC;
	public String gameData;
	
    public SwitchAuton(String LRC) {
    	this.LRC = LRC;
    }
    
    protected void initialize() {
    	
    	
    	this.gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(LRC == "L"){
    		
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L'){
    				System.out.println("Run Left Auto");
    				
    				addSequential(new DriveTo(12, .4, 0));
    				addSequential(new RotatePID(90));
    				
    				addSequential(new DriveTo(1, .4, 90));
    				addSequential(new FlipBucket());
    				//This function runs if the data is for the right side
    			}else {
    				System.out.println("Run Right Auto");
    				
    				addSequential(new DriveTo(16.5, .4, 0));
    				addSequential(new RotatePID(90));
    				
    				addSequential(new DriveTo(12.75, .4, 90));
    				addSequential(new RotatePID(180));
    				
    				addSequential(new FlipBucket());
    				
    			}
    		}
    		
    	}else if(LRC == "R"){
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L'){
    				System.out.println("Run Left Auto");
    				
    				addSequential(new DriveTo(12, .4, 0));
    				addSequential(new RotatePID(90));
    				
    				addSequential(new DriveTo(1, .4, 90));
    				addSequential(new FlipBucket());
    				//This function runs if the data is for the right side
    			}else {
    				System.out.println("Run Right Auto");
    				
    				addSequential(new DriveTo(16.5, .4, 0));
    				addSequential(new RotatePID(90));
    				addSequential(new DriveTo(12.75, .4, 90));
    				addSequential(new RotatePID(180));
    				addSequential(new FlipBucket());
    				
    			}
    		}
    	}else if(LRC == "C"){
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L'){
    				System.out.println("Run Left Auto");
    				
    				addSequential(new DriveTo(5, .4, 0));
    				addSequential(new RotatePID(-90));
    				
    				addSequential(new DriveTo(2, .4, -90));
    				addSequential(new RotatePID(0));
    				
    				addSequential(new DriveTo(2, .4, 0));
    				
    				addSequential(new FlipBucket());
    				//This function runs if the data is for the right side
    			}else {
    				System.out.println("Run Right Auto");
    				
    				addSequential(new DriveTo(5, .4, 0));
    				addSequential(new RotatePID(90));
    				
    				addSequential(new DriveTo(2, .4, 90));
    				addSequential(new RotatePID(0));
    				
    				addSequential(new DriveTo(2, .4, 0));
    				
    				addSequential(new FlipBucket());
    				
    			}
    		}
    	}else{
    		System.out.println("No");
    	}	
    	
    	//This function runs if the field data is for the left side
    	
    	
    	
    	
    }
    
    
    private static void goLRC(){
		
	}
    
}
