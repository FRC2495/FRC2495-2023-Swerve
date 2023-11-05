package frc.robot.auton.common;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;
import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class MoveInLShape extends SequentialCommandGroup {

    public MoveInLShape(SwerveDrivetrain drivetrain, RobotContainer container){

        addCommands(

			new DrivetrainSwerveRelative(drivetrain, container, createFirstPartOfLShapeTrajectory(container)),

			new DrivetrainSwerveRelative(drivetrain, container, createSecondPartOfLShapeTrajectory(container))
            
        ); 
  
    }

    
    public Trajectory createFirstPartOfLShapeTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_NODE_TO_FIRST_PART_OF_L_SHAPE_METERS, 0, Rotation2d.fromDegrees(180)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

	public Trajectory createSecondPartOfLShapeTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_FIRST_PART_OF_L_SHAPE_TO_SECOND_PART_OF_L_SHAPE_METERS, AutonConstants.DISTANCE_FROM_SECOND_PART_OF_L_SHAPE_TO_FINAL_DESTINATION_METERS, Rotation2d.fromDegrees(90)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

   
}