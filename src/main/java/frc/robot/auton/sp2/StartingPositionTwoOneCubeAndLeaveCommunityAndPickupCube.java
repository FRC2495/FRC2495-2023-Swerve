package frc.robot.auton.sp2;

import java.util.List;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;
import frc.robot.auton.common.*;
import frc.robot.commands.drawer.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.neck.*;
import frc.robot.commands.roller.*;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionTwoOneCubeAndLeaveCommunityAndPickupCube extends SequentialCommandGroup {

    public StartingPositionTwoOneCubeAndLeaveCommunityAndPickupCube(RobotContainer container, Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth){

        addCommands(

            // Drop preloaded cube on top node

            new DropTopCube(container, elevator, drawer, roller),

            // Shrink

            new Shrink(container, elevator, drawer),

            // Move backward to first part of kturn

            container.createSwerveControllerCommand(createFirstPartOfNonBumpKturnTrajectory(container)),

			// Move forward to second part of kturn

			container.createSwerveControllerCommand(createSecondPartOfNonBumpKturnTrajectory(container)),

            // Grab mechanism open

			new NeckMoveDownWithStallDetection(neck),

			new PickupCube(container, neck, roller),

            /*new NeckMoveDownWithStallDetection(neck),

            new RollerTimedRoll(roller, .5), // todo change to timed command */

            // Move forward to pick up cube

           // container.createSwerveControllerCommand(createAreaBeforeCubePickupTrajectory(container)),

            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad())
            
        ); 
  
    }

    
    public Trajectory createFirstPartOfNonBumpKturnTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End ahead of where we started, facing sideway
			new Pose2d(AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS, AutonConstants.DISTANCE_FROM_OUTSIDE_COMMUNITY_TO_FIRST_NONBUMP_KTURN_METERS, Rotation2d.fromDegrees(90)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createSecondPartOfNonBumpKturnTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -Y direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(90.0)),
			// Pass through these waypoints
			List.of(),
			// End ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_FIRST_NONBUMP_KTURN_METERS_TO_FIRST_CUBE_PICKUP_METERS, -AutonConstants.DISTANCE_FROM_FIRST_NONBUMP_KTURN_METERS_TO_AREA_BEFORE_FIRST_CUBE_PICKUP_METERS, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createAreaBeforeCubePickupTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_AREA_BEFORE_FIRST_CUBE_PICKUP_TO_CUBE_PICKUP_METERS, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createCubePickupToSecondPartOfNonBumpKTurnTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End back of where we started, facing sideway
			new Pose2d(-AutonConstants.DISTANCE_FROM_FIRST_NONBUMP_KTURN_METERS_TO_FIRST_CUBE_PICKUP_METERS, AutonConstants.DISTANCE_FROM_FIRST_NONBUMP_KTURN_METERS_TO_AREA_BEFORE_FIRST_CUBE_PICKUP_METERS, Rotation2d.fromDegrees(90)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

	public Trajectory createSecondPartOfNonBumpKturnToCubeNode(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -Y direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(90)),
			// Pass through these waypoints
			List.of(),
			// End back of where we started, facing back
			new Pose2d(-AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS, -AutonConstants.DISTANCE_FROM_OUTSIDE_COMMUNITY_TO_FIRST_NONBUMP_KTURN_METERS, Rotation2d.fromDegrees(180)),
			container.createTrajectoryConfig());

		return trajectory;
	}

}