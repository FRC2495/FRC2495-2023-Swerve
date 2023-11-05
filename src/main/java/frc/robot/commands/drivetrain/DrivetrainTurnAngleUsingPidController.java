
package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.SwerveDrivetrain;

/**
 *
 */
public class DrivetrainTurnAngleUsingPidController extends CommandBase {

	private SwerveDrivetrain drivetrain;
	private int m_angle;

	public DrivetrainTurnAngleUsingPidController(SwerveDrivetrain drivetrain, int angle) {
		this.drivetrain = drivetrain;
		m_angle = angle;

		addRequirements(drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrivetrainTurnAngleUsingPidController: initialize");

		drivetrain.turnAngleUsingPidController(m_angle);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		// nothing
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return !drivetrain.tripleCheckTurnAngleUsingPidController();
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrivetrainTurnAngleUsingPidController: end");
		drivetrain.stop();
	}
}
