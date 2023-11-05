
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants.AutoConstants;

import frc.robot.subsystems.SwerveDrivetrain;


/**
 * Follows specified trajectory and then stops the drivetrain using trajectory trackers defined locally.
 */
public class DrivetrainFollowTrajectoryAndStop extends SequentialCommandGroup {

	public DrivetrainFollowTrajectoryAndStop(SwerveDrivetrain drivetrain, Trajectory trajectory) {

		PIDController xController = new PIDController(AutoConstants.X_CONTROLLER_P, 0, 0); // trajectory tracker PID controller for x position

		PIDController yController = new PIDController(AutoConstants.Y_CONTROLLER_P, 0, 0); // trajectory tracker PID controller for y position
		
		ProfiledPIDController thetaController = new ProfiledPIDController(
			AutoConstants.THETA_CONTROLLER_P, 0, 0, AutoConstants.THETA_CONTROLLER_CONSTRAINTS); // trajectory tracker PID controller for rotation
			
		thetaController.enableContinuousInput(-Math.PI, Math.PI);

		addCommands(
			new DrivetrainFollowTrajectory(drivetrain, trajectory, xController, yController, thetaController),
			new DrivetrainStop(drivetrain));
	}

}
