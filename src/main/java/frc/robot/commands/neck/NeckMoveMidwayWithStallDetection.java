
package frc.robot.commands.neck;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Neck;

/**
 *
 */
public class NeckMoveMidwayWithStallDetection extends CommandBase {

	private Neck neck;

	public NeckMoveMidwayWithStallDetection(Neck neck) {
		this.neck = neck;
		addRequirements(neck);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("NeckMoveMidwayWithStallDetection: initialize");
		neck.moveMidway();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		// nothing
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return !neck.tripleCheckMove() || neck.tripleCheckIfStalled();
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interupted) {
		System.out.println("NeckMoveMidwayWithStallDetection: end");
		neck.stay();  // we don't want to stop so we stay at midway...
	}
}
