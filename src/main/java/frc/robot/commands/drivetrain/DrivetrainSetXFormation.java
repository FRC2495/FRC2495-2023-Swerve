
package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.SwerveDrivetrain;

/**
 * Locks drivetrain in X formation.
 */
public class DrivetrainSetXFormation extends CommandBase {

	private SwerveDrivetrain drivetrain;

	public DrivetrainSetXFormation(SwerveDrivetrain drivetrain) {
		this.drivetrain = drivetrain;
		addRequirements(drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrivetrainSetXFormation: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		drivetrain.setX();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false; // we run forever (unless interrupted)
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrivetrainSetXFormation: end");
	}
}
