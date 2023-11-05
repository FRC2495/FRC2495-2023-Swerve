
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


import frc.robot.subsystems.SwerveDrivetrain;


/**
 *
 */
public class DrivetrainResetOdometryAndFollowTrajectoryAndStop extends SequentialCommandGroup {

	public DrivetrainResetOdometryAndFollowTrajectoryAndStop(SwerveDrivetrain drivetrain, Trajectory trajectory) {

		addCommands(
			new DrivetrainResetOdometry(drivetrain, trajectory.getInitialPose()),
			new DrivetrainFollowTrajectoryAndStop(drivetrain, trajectory));
	}

}
