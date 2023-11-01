// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.net.PortForwarder;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	private Command m_autonomousCommand;

	private RobotContainer m_robotContainer;

	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {
		// Port forwarders for LimeLight
		// Do not place these function calls in any periodic functions
		PortForwarder.add(5800, "limelight.local", 5800);
		PortForwarder.add(5801, "limelight.local", 5801);
		PortForwarder.add(5802, "limelight.local", 5802);
		PortForwarder.add(5803, "limelight.local", 5803);
		PortForwarder.add(5804, "limelight.local", 5804);
		PortForwarder.add(5805, "limelight.local", 5805);

		// Instantiate our RobotContainer.  This will perform all our button bindings, and put our
		// autonomous chooser on the dashboard.
		m_robotContainer = new RobotContainer();

		SmartDashboard.putData("Swerve Odometry", m_robotContainer.getField());		
	}

	/**
	 * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
	 * that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before LiveWindow and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		// Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
		// commands, running already-scheduled commands, removing finished or interrupted commands,
		// and running subsystem periodic() methods.  This must be called from the robot's periodic
		// block in order for anything in the Command-based framework to work.
		CommandScheduler.getInstance().run();
	}

	/** This function is called once each time the robot enters Disabled mode. */
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {

		updateToSmartDash();
	}

	/** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_robotContainer.getAutonomousCommand();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.schedule();
		}
	}

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {

		updateToSmartDash();
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
	}

	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {

		updateToSmartDash();
	}

	public void updateToSmartDash()
	{
		SmartDashboard.putNumber("FrontLeftDrivingEncoderPosition", m_robotContainer.getDrivetrain().getFrontLeftModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("FrontLeftTurningEncoderPosition", m_robotContainer.getDrivetrain().getFrontLeftModule().getTurningEncoder().getPosition());
		
		SmartDashboard.putNumber("RearLeftDrivingEncoderPosition", m_robotContainer.getDrivetrain().getRearLeftModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("RearLeftTurningEncoderPosition", m_robotContainer.getDrivetrain().getRearLeftModule().getTurningEncoder().getPosition());
		
		SmartDashboard.putNumber("FrontRightDrivingEncoderPosition", m_robotContainer.getDrivetrain().getFrontRightModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("FrontRightTurningEncoderPosition", m_robotContainer.getDrivetrain().getFrontRightModule().getTurningEncoder().getPosition());
		
		SmartDashboard.putNumber("RearRightDrivingEncoderPosition", m_robotContainer.getDrivetrain().getRearRightModule().getDrivingEncoder().getPosition());
		SmartDashboard.putNumber("RearRightTurningEncoderPosition", m_robotContainer.getDrivetrain().getRearRightModule().getTurningEncoder().getPosition());
	
		SmartDashboard.putNumber("FrontLeftTurningAbsoluteEncoderPosition", m_robotContainer.getDrivetrain().getFrontLeftModule().getTurningAbsoluteEncoder().getPosition());
		SmartDashboard.putNumber("RearLeftTurningAbsoluteEncoderPosition", m_robotContainer.getDrivetrain().getRearLeftModule().getTurningAbsoluteEncoder().getPosition());
		SmartDashboard.putNumber("FrontRightTurningAbsoluteEncoderPosition", m_robotContainer.getDrivetrain().getFrontRightModule().getTurningAbsoluteEncoder().getPosition());
		SmartDashboard.putNumber("RearRightTurningAbsoluteEncoderPosition", m_robotContainer.getDrivetrain().getRearRightModule().getTurningAbsoluteEncoder().getPosition());

		SmartDashboard.putNumber("FrontLeftTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrivetrain().getFrontLeftModule().getTurningAbsoluteEncoder().getVirtualPosition());
		SmartDashboard.putNumber("RearLeftTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrivetrain().getRearLeftModule().getTurningAbsoluteEncoder().getVirtualPosition());
		SmartDashboard.putNumber("FrontRightTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrivetrain().getFrontRightModule().getTurningAbsoluteEncoder().getVirtualPosition());
		SmartDashboard.putNumber("RearRightTurningAbsoluteEncoderVirtualPosition", m_robotContainer.getDrivetrain().getRearRightModule().getTurningAbsoluteEncoder().getVirtualPosition());
	
		SmartDashboard.putNumber("FrontLeftTurningDesiredState", m_robotContainer.getDrivetrain().getFrontLeftModule().getDesiredState().angle.getRadians());
		SmartDashboard.putNumber("RearLeftTurningDesiredState", m_robotContainer.getDrivetrain().getRearLeftModule().getDesiredState().angle.getRadians());
		SmartDashboard.putNumber("FrontRightTurningDesiredState", m_robotContainer.getDrivetrain().getFrontRightModule().getDesiredState().angle.getRadians());
		SmartDashboard.putNumber("RearRightTurningDesiredState", m_robotContainer.getDrivetrain().getRearRightModule().getDesiredState().angle.getRadians());

		/* Display 6-axis Processed Angle Data                                      */
		SmartDashboard.putBoolean(  "IMU_Connected",        m_robotContainer.getDrivetrain().getImu().isConnected());
		SmartDashboard.putBoolean(  "IMU_IsCalibrating",    m_robotContainer.getDrivetrain().getImu().isCalibrating());
		SmartDashboard.putNumber(   "IMU_Yaw",              m_robotContainer.getDrivetrain().getImu().getYaw());
		SmartDashboard.putNumber(   "IMU_Pitch",            m_robotContainer.getDrivetrain().getImu().getPitch());
		SmartDashboard.putNumber(   "IMU_Roll",             m_robotContainer.getDrivetrain().getImu().getRoll());

		m_robotContainer.getField().setRobotPose(m_robotContainer.getDrivetrain().getPose());
		SmartDashboard.putNumber(   "Heading",             m_robotContainer.getDrivetrain().getHeading());


		SmartDashboard.putNumber("AccelZ", m_robotContainer.getAccelerometer().getAccelZ());
		SmartDashboard.putNumber("FilteredAccelZ", m_robotContainer.getAccelerometer().getFilteredAccelZ());
		SmartDashboard.putNumber("Tilt", m_robotContainer.getAccelerometer().getTilt());
		SmartDashboard.putNumber("FilteredTilt", m_robotContainer.getAccelerometer().getFilteredTilt());
		SmartDashboard.putNumber("AccurateTilt", m_robotContainer.getAccelerometer().getAccurateTilt());
		SmartDashboard.putBoolean("isFlat", m_robotContainer.getAccelerometer().isFlat());
		SmartDashboard.putBoolean("isSuperFlat", m_robotContainer.getAccelerometer().isSuperFlat());
		SmartDashboard.putNumber("AccuratePitch", m_robotContainer.getAccelerometer().getAccuratePitch());
		SmartDashboard.putNumber("AccurateRoll", m_robotContainer.getAccelerometer().getAccurateRoll());
		SmartDashboard.putNumber("FilteredAccurateRoll", m_robotContainer.getAccelerometer().getFilteredAccurateRoll());


		SmartDashboard.putBoolean("Elevator Forward Limit Switch", m_robotContainer.getElevator().getForwardLimitSwitchState());
		SmartDashboard.putBoolean("Elevator Reverse Limit Switch", m_robotContainer.getElevator().getReverseLimitSwitchState());
		SmartDashboard.putNumber("Elevator Enc Position", m_robotContainer.getElevator().getEncoderPosition());
		SmartDashboard.putBoolean("Elevator IsMoving?", m_robotContainer.getElevator().isMoving());
		SmartDashboard.putNumber("Elevator Target", m_robotContainer.getElevator().getTarget());
		SmartDashboard.putBoolean("Elevator isStalled?", m_robotContainer.getElevator().isStalled());
		SmartDashboard.putBoolean("Elevator isDown", m_robotContainer.getElevator().isDown());
		SmartDashboard.putBoolean("Elevator isMidway", m_robotContainer.getElevator().isMidway());
		SmartDashboard.putBoolean("Elevator isUp", m_robotContainer.getElevator().isUp());
		SmartDashboard.putBoolean("Elevator isDangerous", m_robotContainer.getElevator().isDangerous());

		SmartDashboard.putBoolean("Drawer Forward Limit Switch", m_robotContainer.getDrawer().getForwardLimitSwitchState());
		SmartDashboard.putBoolean("Drawer Reverse Limit Switch", m_robotContainer.getDrawer().getReverseLimitSwitchState());
		SmartDashboard.putNumber("Drawer Enc Position", m_robotContainer.getDrawer().getEncoderPosition());
		SmartDashboard.putBoolean("Drawer IsMoving?", m_robotContainer.getDrawer().isMoving());
		SmartDashboard.putNumber("Drawer Target", m_robotContainer.getDrawer().getTarget());
		SmartDashboard.putBoolean("Drawer isStalled?", m_robotContainer.getDrawer().isStalled());
		SmartDashboard.putBoolean("Drawer isRetracted", m_robotContainer.getDrawer().isRetracted());
		SmartDashboard.putBoolean("Drawer isMidway", m_robotContainer.getDrawer().isMidway());
		SmartDashboard.putBoolean("Drawer isExtended", m_robotContainer.getDrawer().isExtended());
		SmartDashboard.putBoolean("Drawer isDangerous", m_robotContainer.getDrawer().isDangerous());

		SmartDashboard.putBoolean("Neck Reverse Limit Switch", m_robotContainer.getNeck().getReverseLimitSwitchState());
		SmartDashboard.putBoolean("Neck Forward Limit Switch", m_robotContainer.getNeck().getForwardLimitSwitchState());
		SmartDashboard.putNumber("Neck Position", m_robotContainer.getNeck().getPosition());
		SmartDashboard.putNumber("Neck Enc Position", m_robotContainer.getNeck().getEncoderPosition());
		SmartDashboard.putBoolean("Neck IsMoving?", m_robotContainer.getNeck().isMoving());
		SmartDashboard.putNumber("Neck Target", m_robotContainer.getNeck().getTarget());
		SmartDashboard.putBoolean("Neck isStalled?", m_robotContainer.getNeck().isStalled());
		SmartDashboard.putBoolean("Neck isDown", m_robotContainer.getNeck().isDown());
		SmartDashboard.putBoolean("Neck isMidway", m_robotContainer.getNeck().isMidway());
		SmartDashboard.putBoolean("Neck isUp", m_robotContainer.getNeck().isUp());
		SmartDashboard.putBoolean("Neck isDangerous", m_robotContainer.getNeck().isDangerous());

		SmartDashboard.putBoolean("Roller IsRolling?", m_robotContainer.getRoller().isRolling());
		SmartDashboard.putBoolean("Roller IsReleasing?", m_robotContainer.getRoller().isReleasing());

		SmartDashboard.putString("Mouth Position", m_robotContainer.getMouth().getPosition().toString());
		SmartDashboard.putBoolean("Mouth isDangerous", m_robotContainer.getMouth().isDangerous());


		SmartDashboard.putString("Auton selected", m_robotContainer.getAutonChooser().getSelected());	
		SmartDashboard.putString("Game piece", m_robotContainer.getGamePieceChooser().getSelected());
		SmartDashboard.putString("Start position", m_robotContainer.getStartPositionChooser().getSelected());
		SmartDashboard.putString("Main target", m_robotContainer.getMainTargetChooser().getSelected());
		SmartDashboard.putString("Camera option", m_robotContainer.getCameraOptionChooser().getSelected());
		SmartDashboard.putString("Sonar option", m_robotContainer.getSonarOptionChooser().getSelected());
		SmartDashboard.putString("Release chosen", m_robotContainer.getReleaseChooser().getSelected());
		SmartDashboard.putString("Auton option", m_robotContainer.getAutonOptionChooser().getSelected());
	}

	@Override
	public void testInit() {
		// Cancels all running commands at the start of test mode.
		CommandScheduler.getInstance().cancelAll();
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {}
}
