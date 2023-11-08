package frc.robot.auton.common;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class MoveInLShapeInReverse extends SequentialCommandGroup {

	private double sideLength;

    public MoveInLShapeInReverse(SwerveDrivetrain drivetrain, RobotContainer container, double sideLength) {

		this.sideLength = sideLength;

        addCommands(

			new DrivetrainSwerveRelative(drivetrain, container, createLShapeInReverseTrajectory(container))
           
        ); 
  
    }

	public Trajectory createLShapeInReverseTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End ahead of where we started, facing sideway
			// https://docs.wpilib.org/en/stable/docs/software/advanced-controls/geometry/coordinate-systems.html
			new Pose2d(+sideLength, +sideLength, Rotation2d.fromDegrees(-90)),
			container.createReverseTrajectoryConfig());

		return trajectory;
	}

   
}