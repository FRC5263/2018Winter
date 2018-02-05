/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package org.usfirst.frc.team5263.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc.team5263.robot.RobotMap;
import org.usfirst.frc.team5263.robot.commands.DriveTo;
import org.usfirst.frc.team5263.robot.commands.DriverOperated;
import org.usfirst.frc.team5263.robot.commands.RotatePID;
import org.usfirst.frc.team5263.robot.commands.Rotation;
import org.usfirst.frc.team5263.robot.commands.TestPiston;
import org.usfirst.frc.team5263.robot.commands.Wait;
import org.usfirst.frc.team5263.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5263.robot.subsystems.Pneumatics;
//import org.usfirst.frc.team5263.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
//	public static final ExampleSubsystem kExampleSubsystem
//			= new ExampleSubsystem();
	public static final Pneumatics myPneumatics = new Pneumatics();
	public static final DriveTrain myDrive = new DriveTrain();
	
	
	public static OI m_oi;
	Command teleop = new DriverOperated();
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		m_oi = new OI();
		
		m_chooser.addDefault("Default Auto", new TestPiston());
		m_chooser.addObject("Rotate to", new Rotation(90));
		m_chooser.addObject("Drive To", new DriveTo(3, .5));
		m_chooser.addObject("Wait", new Wait(5));
		m_chooser.addObject("RotatePID", new RotatePID(90));
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**	
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		System.out.println("autonomous init");
		if (m_autonomousCommand != null) {
			System.out.println("Cancelling existing command");
			m_autonomousCommand.cancel();
		}
		
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		
		if (m_autonomousCommand != null) {
			System.out.println("selected command is " + m_autonomousCommand.getName());
			m_autonomousCommand.start();
		} else {
			System.out.println("selected command is NULL, running NO AUTON");
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		teleop.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {		
		
	}

	@Override
	public void robotPeriodic() {
		DriveTrain.putAHRSOnDashboard();
	}
}
