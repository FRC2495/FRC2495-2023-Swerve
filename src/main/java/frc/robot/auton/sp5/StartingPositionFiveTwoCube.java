package frc.robot.auton.sp5;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;
import frc.robot.auton.common.*;
import frc.robot.commands.drivetrain.*;
import frc.robot.commands.neck.*;
import frc.robot.commands.roller.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionFiveTwoCube extends SequentialCommandGroup {

    public StartingPositionFiveTwoCube(SwerveDrivetrain drivetrain, RobotContainer container, Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth){

        addCommands(

            // Drop preloaded cube on top node

            new DropTopCube(container, elevator, drawer, roller),

            // Shrink

            new Shrink(container, elevator, drawer),

            // Move backward to first part of kturn

            new DrivetrainSwerveRelative(drivetrain, container, createFirstPartOfBumpKturnTrajectory(container)),

			// Move forward to second part of kturn

			new DrivetrainSwerveRelative(drivetrain, container, createSecondPartOfBumpKturnTrajectory(container)),

            // Grab mechanism open

			new NeckMoveDownWithStallDetection(neck),

			new PickupCube(drivetrain, container, neck, roller),

            //new NeckMoveDownWithStallDetection(neck),

            //new RollerTimedRoll(roller, .5), // todo change to timed command 

            // Move forward to pick up cube

            // container.createSwerveControllerCommand(createTrajectory3(container)),

			// Shrink

            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad()),

            // Move to first part of kturn

            new DrivetrainSwerveRelative(drivetrain, container, createCubePickupToSecondPartOfBumpKTurnTrajectory(container)),

            // Move back to cube node

            new DrivetrainSwerveRelative(drivetrain, container, createSecondPartOfBumpKturnToCubeNode(container)),

            // Drop cube for mid node

            new RollerTimedRelease(roller, .5)
             

            /*// Move to second cube while rotating 180 degrees

            // Grab mechanism open

            new NeckMoveDownWithStallDetection(neck),

            new RollerRoll(roller), // todo change to timed command 

            // Move forward to pick up cube


            // Shrink

            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad()),

            // Move back to shelf while rotating 180 degrees

            // Drop cube

            new NeckMoveDownWithStallDetection(neck),

            new RollerRelease(roller) // todo change to timed command */
 
            
        ); 
  
    }

    
	public Trajectory createFirstPartOfBumpKturnTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End ahead of where we started, facing sideway
			new Pose2d(AutonConstants.DISTANCE_FROM_NODE_TO_FIRST_PART_OF_BUMP_KTURN_METERS, AutonConstants.DISTANCE_FROM_FIRST_PART_OF_BUMP_KTURN_TO_SECOND_PART_OF_KTURN_METERS, Rotation2d.fromDegrees(90)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createSecondPartOfBumpKturnTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -Y direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(90.0)),
			// Pass through these waypoints
			List.of(),
			// End ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_FIRST_PART_OF_BUMP_KTURN_TO_AREA_BEFORE_CUBE_PICKUP_METERS, -AutonConstants.DISTANCE_FROM_SECOND_PART_OF_BUMP_KTURN_TO_AREA_BEFORE_CUBE_PICKUP_METERS, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}

    public Trajectory createCubePickupToSecondPartOfBumpKTurnTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End back of where we started, facing sideway
			new Pose2d(-AutonConstants.DISTANCE_FROM_FIRST_PART_OF_BUMP_KTURN_TO_AREA_BEFORE_CUBE_PICKUP_METERS, AutonConstants.DISTANCE_FROM_SECOND_PART_OF_BUMP_KTURN_TO_AREA_BEFORE_CUBE_PICKUP_METERS, Rotation2d.fromDegrees(90)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

	public Trajectory createSecondPartOfBumpKturnToCubeNode(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -Y direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(90)),
			// Pass through these waypoints
			List.of(),
			// End back of where we started, facing back
			new Pose2d(-AutonConstants.DISTANCE_FROM_NODE_TO_FIRST_PART_OF_BUMP_KTURN_METERS, -AutonConstants.DISTANCE_FROM_FIRST_PART_OF_BUMP_KTURN_TO_SECOND_PART_OF_KTURN_METERS, Rotation2d.fromDegrees(180)),
			container.createTrajectoryConfig());

		return trajectory;
	}

}