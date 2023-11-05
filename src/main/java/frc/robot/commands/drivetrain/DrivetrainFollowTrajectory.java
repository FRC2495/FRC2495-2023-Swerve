
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;

import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;

import frc.robot.Constants.DrivetrainConstants;
import frc.robot.subsystems.SwerveDrivetrain;

/**
 * Follows specified trajectory. Exact same as SwerveControllerCommand which it is derived from.
 */
public class DrivetrainFollowTrajectory extends SwerveControllerCommand {

	//private SwerveDrivetrain drivetrain;

	public DrivetrainFollowTrajectory(SwerveDrivetrain drivetrain, Trajectory trajectory, PIDController xController, PIDController yController, ProfiledPIDController thetaController) {
		super(
			trajectory, // trajectory to follow
			drivetrain::getPose, // Functional interface to feed supplier
			DrivetrainConstants.DRIVE_KINEMATICS, // kinematics of the drivetrain
			xController, // trajectory tracker PID controller for x position
			yController, // trajectory tracker PID controller for y position
			thetaController, // trajectory tracker PID controller for rotation
			drivetrain::setModuleStates, // raw output module states from the position controllers
			drivetrain); // subsystems to require
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrivetrainFollowTrajectory: initialize");
		super.initialize();
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrivetrainFollowTrajectory: end");
		super.end(interrupted);
	}
}
