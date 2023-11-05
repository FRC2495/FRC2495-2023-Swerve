
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.SwerveDrivetrain;

/**
 * Resets odometry to the specified pose.
 */
public class DrivetrainResetOdometry extends InstantCommand {

	private SwerveDrivetrain drivetrain;
	private Pose2d pose2d;

	public DrivetrainResetOdometry(SwerveDrivetrain drivetrain, Pose2d pose2d) {
		this.drivetrain = drivetrain;
		this.pose2d = pose2d;

		addRequirements(drivetrain);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("DrivetrainResetOdometry: initialize");
		drivetrain.resetOdometry(pose2d);
	}

}
