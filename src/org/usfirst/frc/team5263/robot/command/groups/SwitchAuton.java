package org.usfirst.frc.team5263.robot.command.groups;

import org.usfirst.frc.team5263.robot.commands.DriveTo;
import org.usfirst.frc.team5263.robot.commands.FlipBucket;
import org.usfirst.frc.team5263.robot.commands.Lift;
import org.usfirst.frc.team5263.robot.commands.RotatePID;
import org.usfirst.frc.team5263.robot.commands.Wait;

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
        			
        			addSequential(new DriveTo(12, .4, 0, 6));
        			addSequential(new RotatePID(90));
        			
        			addSequential(new DriveTo(1, .4, 90, 1));
        			addSequential(new Lift(-0.4, 0.5));
        			addSequential(new FlipBucket());
        			//This function runs if the data is for the right side
        		}else {
        			System.out.println("Run Right Auto");
        			
        			addSequential(new DriveTo(17.5, .4, 0, 7));
        			addSequential(new RotatePID(90));
        			
        			addSequential(new DriveTo(13.25, .4, 90, 6));
        			addSequential(new RotatePID(180));
        			addSequential(new DriveTo(0.5, .4, 180, 1));
        			
        			addSequential(new Lift(-0.4, 0.5));
        			addSequential(new FlipBucket());	
        			}
        	}
    		
    	}else if(LRC == "R"){
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L'){
    				System.out.println("Run Left Auto");
    				
    				addSequential(new DriveTo(16.5, .4, 0, 7));
        			addSequential(new RotatePID(-90));
        			
        			addSequential(new DriveTo(13.25, .4, -90, 6));
        			addSequential(new RotatePID(-180));
        			addParallel(new DriveTo(0.5, .4, -180, 1));
        			
    				addSequential(new FlipBucket());
    				//This function runs if the data is for the right side
    			}else {
    				System.out.println("Run Right Auto");
    				
    				addSequential(new DriveTo(12, .4, 0, 6));
        			addSequential(new RotatePID(-90));
        			
        			addSequential(new DriveTo(1, .4, -90, 1));
        			addSequential(new FlipBucket());
    				
    			}
    		}
    	}else if(LRC == "C"){
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L'){
    				System.out.println("Run Left Auto");
    				
    				addSequential(new Wait(5));
    				addSequential(new DriveTo(5, .4, 0, 3));
    				addSequential(new RotatePID(-90));
    				
    				addSequential(new DriveTo(5, .4, -90, 3));
    				addSequential(new RotatePID(0));
    				addSequential(new DriveTo(3, .4, 0, 3));
    				addSequential(new RotatePID(90));
    				
    				addSequential(new DriveTo(3, .4, 90, 2));
    				addSequential(new FlipBucket());
    				//This function runs if the data is for the right side
    			}else {
    				System.out.println("Run Right Auto");
    				addSequential(new Wait(5));
    				
    				addSequential(new DriveTo(5, .4, 0, 3));
    				addSequential(new RotatePID(90));
    				
    				addSequential(new DriveTo(5, .4, 90, 3));
    				addSequential(new RotatePID(0));
    				addSequential(new DriveTo(3, .4, 0, 2));
    				addSequential(new RotatePID(-90));
    				
    				addSequential(new DriveTo(5, .4, 90, 4));
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
