
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


import frc.robot.subsystems.SwerveDrivetrain;


/**
 * Resets odometry at the initial pose of the specified trajectory and then follows specified trajectory and then stops.
 */
public class DrivetrainResetOdometryAndFollowTrajectoryAndStop extends SequentialCommandGroup {

	public DrivetrainResetOdometryAndFollowTrajectoryAndStop(SwerveDrivetrain drivetrain, Trajectory trajectory) {

		addCommands(
			new DrivetrainResetOdometry(drivetrain, trajectory.getInitialPose()),
			new DrivetrainFollowTrajectoryAndStop(drivetrain, trajectory));
	}

}
