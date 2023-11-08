package frc.robot.auton.common;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class MoveInSShape extends SequentialCommandGroup {

	private double distance;

    public MoveInSShape(SwerveDrivetrain drivetrain, RobotContainer container, double distance) {

		this.distance = distance;

        addCommands(

			new DrivetrainSwerveRelative(drivetrain, container, createSShapeTrajectory(container))
           
        ); 
  
    }

	public Trajectory createSShapeTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the +X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(new Translation2d(1.0*distance/3.0, -1.0*distance/3.0), new Translation2d(2.0*distance/3.0, +1.0*distance/3.0)),
			// End n meters straight ahead of where we started, facing forward
			// https://docs.wpilib.org/en/stable/docs/software/advanced-controls/geometry/coordinate-systems.html
			new Pose2d(distance, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}
   
}