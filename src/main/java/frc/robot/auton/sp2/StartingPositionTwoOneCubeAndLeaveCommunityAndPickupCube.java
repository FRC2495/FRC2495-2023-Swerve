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

            new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),

            new RollerTimedRelease(roller, .5), // todo change to timed command 

            // Shrink

            new DrawerSafeRetractWithStallDetection(drawer, mouth, neck, container.getCopilotGamepad()),

            new ElevatorMoveDownWithStallDetection(elevator),

            // Move backward to first part of kturn

            container.createSwerveControllerCommand(createTrajectory(container.createReverseTrajectoryConfig())),

			// Move forward to second part of kturn

			container.createSwerveControllerCommand(createTrajectory2(container.createTrajectoryConfig())),

            // Grab mechanism open

			new NeckMoveDownWithStallDetection(neck),

			new PickupCube(container, neck, roller),

            /*new NeckMoveDownWithStallDetection(neck),

            new RollerTimedRoll(roller, .5), // todo change to timed command */

            // Move forward to pick up cube

            container.createSwerveControllerCommand(createTrajectory3(container.createTrajectoryConfig())),

            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad())
            
        ); 
  
    }

    
    public Trajectory createTrajectory(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS, AutonConstants.DISTANCE_FROM_OUTSIDE_COMMUNITY_TO_FIRST_KTURN_METERS, new Rotation2d(90)),
			config);

		return trajectory;
	}

    public Trajectory createTrajectory2(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(90.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_FIRST_CUBE_PICKUP_METERS, -AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_AREA_BEFORE_FIRST_CUBE_PICKUP_METERS, new Rotation2d(0)),
			config);

		return trajectory;
	}

    public Trajectory createTrajectory3(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_FIRST_CUBE_PICKUP_METERS, -AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_AREA_BEFORE_FIRST_CUBE_PICKUP_METERS, new Rotation2d(0)),
			config);

		return trajectory;
	}

    public Trajectory createTrajectory4(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(-AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_FIRST_CUBE_PICKUP_METERS, AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_AREA_BEFORE_FIRST_CUBE_PICKUP_METERS, new Rotation2d(90)),
			config);

		return trajectory;
	}

	public Trajectory createTrajectory5(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(-AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS, -AutonConstants.DISTANCE_FROM_OUTSIDE_COMMUNITY_TO_FIRST_KTURN_METERS, new Rotation2d(180)),
			config);

		return trajectory;
	}

}