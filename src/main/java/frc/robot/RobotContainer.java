// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController; 
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.List;

import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indicator;
import frc.robot.commands.indicator.*;
import frc.robot.auton.*;


/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

	public static final double GAMEPAD_AXIS_THRESHOLD = 0.05;

	// choosers (for auton)
	
	public static final String AUTON_DO_NOTHING = "Do Nothing";
	public static final String AUTON_CUSTOM = "My Auto";
	public static final String AUTON_SAMPLE_SWERVE = "Sample Swerve";
	private String autonSelected;
	private SendableChooser<String> autonChooser = new SendableChooser<>();

	public static final String GAME_PIECE_NONE = "None";
	public static final String GAME_PIECE_1_CONE = "1 Cone";
	public static final String GAME_PIECE_2_CONES = "2 Cones";
	private String gamePieceSelected;
	private SendableChooser<String> gamePieceChooser = new SendableChooser<>();
	
	public static final String START_POSITION_1 = "Starting Position 1";
	public static final String START_POSITION_2 = "Starting Position 2";
	public static final String START_POSITION_3 = "Starting Position 3";
	public static final String START_POSITION_4 = "Starting Position 4";
	public static final String START_POSITION_5 = "Starting Position 5";
	public static final String START_POSITION_6 = "Starting Position 6";
	private String startPosition;
	private SendableChooser<String> startPositionChooser = new SendableChooser<>();

	public static final String MAIN_TARGET_CONE_NODE = "Cone Node";
	public static final String MAIN_TARGET_TWO_CONE_NODES = "Two Cone Nodes";
	public static final String MAIN_TARGET_CHARGING_STATION = "Charging Station";
	public static final String MAIN_TARGET_NOWHERE = "Nowhere";
	private String mainTarget;
	private SendableChooser<String> mainTargetChooser = new SendableChooser<>();
	
	public static final String CAMERA_OPTION_USE_ALWAYS = "Always";
	public static final String CAMERA_OPTION_USE_OPEN_LOOP_ONLY = "Open Loop Only";
	public static final String CAMERA_OPTION_USE_CLOSED_LOOP_ONLY = "Closed Loop Only";
	public static final String CAMERA_OPTION_USE_NEVER = "Never";
	private String cameraOption;
	private SendableChooser<String> cameraOptionChooser = new SendableChooser<>();
	
	public static final String SONAR_OPTION_USE_ALWAYS = "Always";
	public static final String SONAR_OPTION_USE_RELEASE_ONLY = "Release Only";
	public static final String SONAR_OPTION_USE_GRASP_ONLY = "Grasp Only";
	public static final String SONAR_OPTION_USE_NEVER = "Never";
	private String sonarOption;
	private SendableChooser<String> sonarOptionChooser = new SendableChooser<>();
	
	public static final String CLAW_OPTION_RELEASE = "Release";
	public static final String CLAW_OPTION_DONT_RELEASE = "Don't Release"; 
	private String releaseSelected;
	private SendableChooser<String> releaseChooser = new SendableChooser<>();

	public static final String AUTON_OPTION_JUST_DROP_CONE = "Just Drop Cone";
	public static final String AUTON_OPTION_ALSO_DOCK = "Also Dock";
	public static final String AUTON_OPTION_LEAVE_COMMUNITY = "Leave Community";
	public static final String AUTON_OPTION_ALSO_PICKUP_CONE = "Also Pickup Cone";
	private String autonOption;
	private SendableChooser<String> autonOptionChooser = new SendableChooser<>();

	// sensors

	// motorized devices

	private final Drivetrain drivetrain = new Drivetrain();

	// pneumatic devices

	// misc

	private final Field2d field = new Field2d(); //  a representation of the field

	private final Indicator indicator = new Indicator(null);

	// The driver's controller
	CommandXboxController driverGamepad = new CommandXboxController(Ports.USB.GAMEPAD);

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {

		// choosers (for auton)
		
		autonChooser.setDefaultOption("Do Nothing", AUTON_DO_NOTHING);
		autonChooser.addOption("My Auto", AUTON_CUSTOM);
		autonChooser.addOption("Sample Swerve", AUTON_SAMPLE_SWERVE);
		SmartDashboard.putData("Auto choices", autonChooser);

		gamePieceChooser.setDefaultOption("None", GAME_PIECE_NONE);
		gamePieceChooser.addOption("1 Cone", GAME_PIECE_1_CONE);
		gamePieceChooser.addOption("2 Cones", GAME_PIECE_2_CONES);
		SmartDashboard.putData("Game piece choices", gamePieceChooser);

		startPositionChooser.setDefaultOption("Starting Position 1", START_POSITION_1);
		startPositionChooser.addOption("Starting Position 2", START_POSITION_2);
		startPositionChooser.addOption("Starting Position 3", START_POSITION_3);
		startPositionChooser.addOption("Starting Position 4", START_POSITION_4);
		startPositionChooser.addOption("Starting Position 5", START_POSITION_5);
		startPositionChooser.addOption("Starting Position 6", START_POSITION_6);
		SmartDashboard.putData("Start positions", startPositionChooser);

		mainTargetChooser.setDefaultOption("To Nowhere", MAIN_TARGET_NOWHERE);
		mainTargetChooser.addOption("Cone Node", MAIN_TARGET_CONE_NODE);
		mainTargetChooser.addOption("Two Cone Nodes", MAIN_TARGET_TWO_CONE_NODES);
		mainTargetChooser.addOption("Charging Station", MAIN_TARGET_CHARGING_STATION);
		SmartDashboard.putData("Main targets", mainTargetChooser);
		
		cameraOptionChooser.setDefaultOption("Always", CAMERA_OPTION_USE_ALWAYS);
		cameraOptionChooser.addOption("Open Loop Only", CAMERA_OPTION_USE_OPEN_LOOP_ONLY);
		cameraOptionChooser.addOption("Closed Loop Only", CAMERA_OPTION_USE_CLOSED_LOOP_ONLY);
		cameraOptionChooser.addOption("Never", CAMERA_OPTION_USE_NEVER);		
		SmartDashboard.putData("Camera options", cameraOptionChooser);
		
		sonarOptionChooser.setDefaultOption("Always", SONAR_OPTION_USE_ALWAYS);
		sonarOptionChooser.addOption("Release Only", SONAR_OPTION_USE_RELEASE_ONLY);
		sonarOptionChooser.addOption("Grasp Only", SONAR_OPTION_USE_GRASP_ONLY);		
		sonarOptionChooser.addOption("Never", SONAR_OPTION_USE_NEVER);
		SmartDashboard.putData("Sonar options", sonarOptionChooser);
		
		releaseChooser.setDefaultOption("Release", CLAW_OPTION_RELEASE);
		releaseChooser.addOption("Don't release", CLAW_OPTION_DONT_RELEASE);
		SmartDashboard.putData("Release options", releaseChooser);

		autonOptionChooser.setDefaultOption("Just Drop Cone", AUTON_OPTION_JUST_DROP_CONE);
		autonOptionChooser.addOption("Also Dock", AUTON_OPTION_ALSO_DOCK);
		autonOptionChooser.addOption("Leave Community", AUTON_OPTION_LEAVE_COMMUNITY);
		autonOptionChooser.addOption("Also Pickup Cone", AUTON_OPTION_ALSO_PICKUP_CONE);
	
		SmartDashboard.putData("Auton options", autonOptionChooser);		


		// Configure the button bindings
		configureButtonBindings();

		// Configure default commands
		drivetrain.setDefaultCommand(
			// The left stick controls translation of the robot.
			// Turning is controlled by the X axis of the right stick.
			// We are inverting LeftY because Xbox controllers return negative values when we push forward.
			// We are inverting LeftX because we want a positive value when we pull to the left. Xbox controllers return positive values when you pull to the right by default.
			// We are also inverting RightX because we want a positive value when we pull to the left (CCW is positive in mathematics).
			new RunCommand(
				() -> drivetrain.drive(
					-MathUtil.applyDeadband(driverGamepad.getLeftY(), GAMEPAD_AXIS_THRESHOLD),
					-MathUtil.applyDeadband(driverGamepad.getLeftX(), GAMEPAD_AXIS_THRESHOLD),
					-MathUtil.applyDeadband(driverGamepad.getRightX(), GAMEPAD_AXIS_THRESHOLD),
					true, true),
				drivetrain));

		indicator.setDefaultCommand(new IndicatorScrollRainbow(indicator)); // temp
	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be
	 * created by
	 * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
	 * subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
	 * passing it to a
	 * {@link JoystickButton}.
	 */
	private void configureButtonBindings() {
		driverGamepad.x()
			.whileTrue(new RunCommand(
				() -> drivetrain.setX(),
				drivetrain));

		driverGamepad.y()
			.onTrue(new InstantCommand(
				() -> drivetrain.resetEncoders(),
				drivetrain).ignoringDisable(true));

		driverGamepad.a()
			.onTrue(new InstantCommand(
				() -> drivetrain.zeroHeading(),
				drivetrain).ignoringDisable(true));      
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		autonSelected = autonChooser.getSelected();
		System.out.println("Auton selected: " + autonSelected);	

		gamePieceSelected = gamePieceChooser.getSelected();
		System.out.println("Game piece selected: " + gamePieceSelected);		

		startPosition = startPositionChooser.getSelected();
		System.out.println("Start position: " + startPosition);

		mainTarget = mainTargetChooser.getSelected();
		System.out.println("Main target: " + mainTarget);
		
		cameraOption = cameraOptionChooser.getSelected();
		System.out.println("Camera option: " + cameraOption);
		
		sonarOption = sonarOptionChooser.getSelected();
		System.out.println("Sonar option: " + sonarOption);
		
		releaseSelected = releaseChooser.getSelected();
		System.out.println("Release chosen: " + releaseSelected);

		autonOption = autonOptionChooser.getSelected();
		System.out.println("Auton option: " + autonOption);
		

		switch (autonSelected) {
			case AUTON_SAMPLE_SWERVE:
				return getSampleSwerveControllerCommand();
				//break;

			case AUTON_CUSTOM:
				return new CustomAuton(gamePieceSelected, startPosition, mainTarget, cameraOption, sonarOption, autonOption);
				//break;

			case AUTON_DO_NOTHING:
				return null;
				//break;
				
			default:
				// nothing
				return null;
				//break;
		} // end switch
	}
	
	public Command getSampleSwerveControllerCommand() {
		// Create config for trajectory
		TrajectoryConfig config = new TrajectoryConfig(
			AutoConstants.kMaxSpeedMetersPerSecond,
			AutoConstants.kMaxAccelerationMetersPerSecondSquared)
			// Add kinematics to ensure max speed is actually obeyed
			.setKinematics(DrivetrainConstants.kDriveKinematics);

		// An example trajectory to follow. All units in meters.
		Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, new Rotation2d(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
			// End 3 meters straight ahead of where we started, facing forward
			new Pose2d(3, 0, new Rotation2d(0)),
			config);

		var thetaController = new ProfiledPIDController(
			AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
			
		thetaController.enableContinuousInput(-Math.PI, Math.PI);

		SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
			exampleTrajectory,
			drivetrain::getPose, // Functional interface to feed supplier
			DrivetrainConstants.kDriveKinematics,

			// Position controllers
			new PIDController(AutoConstants.kPXController, 0, 0),
			new PIDController(AutoConstants.kPYController, 0, 0),
			thetaController,
			drivetrain::setModuleStates,
			drivetrain);

		// Reset odometry to the starting pose of the trajectory.
		drivetrain.resetOdometry(exampleTrajectory.getInitialPose());

		field.getObject("exampleTrajectory").setTrajectory(exampleTrajectory);

		// Run path following command, then stop at the end.
		return swerveControllerCommand.andThen(() -> drivetrain.drive(0, 0, 0, false, false));
	}

	public Field2d getField()
	{
		return field;
	}

	public Drivetrain getDrivetrain()
	{
		return drivetrain;
	}
}
