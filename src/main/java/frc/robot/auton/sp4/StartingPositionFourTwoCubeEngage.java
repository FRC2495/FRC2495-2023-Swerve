package frc.robot.auton.sp4;

import java.util.List;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;
import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionFourTwoCubeEngage extends SequentialCommandGroup {

    public StartingPositionFourTwoCubeEngage(SwerveDrivetrain drivetrain, RobotContainer container, Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth) {

        addCommands(

            // Drop preloaded cube
            /*new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),

            new RollerRelease(roller),

            // Shrink
            new DrawerSafeRetractWithStallDetection(drawer, mouth, neck, container.getCopilotGamepad()),

            new ElevatorMoveDownWithStallDetection(elevator),*/

            // Move to cube directly over charge station

            new DrivetrainSwerveRelative(drivetrain, container, createTrajectory(container))

            // Get ready to pick up the cube

            /*new NeckMoveDownWithStallDetection(neck),

            new RollerRoll(roller),

            // Move forward to pick up cube


            // Shrink

            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad()),

            // Move back to shelf over charge station*/

        ); 
  
    }

    public Trajectory createTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(new Translation2d(1, 1)),
			// End straight ahead of where we started, facing forward
			new Pose2d(Units.inchesToMeters(AutonConstants.DISTANCE_FROM_START_OF_CHARGING_STATION_TO_DOCKED_AT_CHARGING_STATION + AutonConstants.DISTANCE_FROM_DOCK_TO_OUTSIDE_COMMUNITY), 0, Rotation2d.fromDegrees(0)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}
   

    public Trajectory createSCurveTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
			// End 3 meters straight ahead of where we started, facing forward
			new Pose2d(3, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}


    public Trajectory createStraightInReverseTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(/*new Translation2d(1, 1)*/),
			// End 5 meters straight ahead of where we started, facing back
			new Pose2d(5, 0, Rotation2d.fromDegrees(180.0)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createStraightForwardTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(),
			// End 5 meters straight ahead of where we started, facing forward
			new Pose2d(5, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}


}