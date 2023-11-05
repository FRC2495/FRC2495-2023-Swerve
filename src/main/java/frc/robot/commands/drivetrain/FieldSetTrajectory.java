
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.RobotContainer;

/**
 * Sets trajectory object of field with specified trajectory.
 */
public class FieldSetTrajectory extends InstantCommand {

	private RobotContainer	container;
	private Trajectory trajectory;

	public FieldSetTrajectory(RobotContainer container, Trajectory trajectory) {
		this.container = container;
		this.trajectory = trajectory;

		//addRequirements(); // nothing to reserve
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("FieldSetTrajectory: initialize");
		container.getField().getObject("trajectory").setTrajectory(trajectory);
	}

}
