
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.SwerveDrivetrain;
import frc.robot.RobotContainer;

/**
 * Swerve-drives along trajectory. Trajectory is assumed to contain relative coordinates (that is the starting position should be (0,0)).
 */
public class DrivetrainSwerveRelative extends SequentialCommandGroup {

	public DrivetrainSwerveRelative(SwerveDrivetrain drivetrain, RobotContainer container, Trajectory trajectory) {

		addCommands(
			new FieldSetTrajectory(container, trajectory, true),
			new DrivetrainResetOdometryAndFollowTrajectoryAndStop(drivetrain, trajectory));
	}

}
