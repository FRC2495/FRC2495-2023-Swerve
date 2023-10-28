
package frc.robot.commands.neck;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Neck;

/**
 *
 */
public class NeckMoveDownWithStallDetection extends CommandBase {

	private Neck neck;

	public NeckMoveDownWithStallDetection(Neck neck) {
		this.neck = neck;
		addRequirements(neck);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("NeckMoveDownWithStallDetection: initialize");
		neck.moveDown();
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
	public void end(boolean interrupted) {
		System.out.println("NeckMoveDownWithStallDetection: end");
		neck.stop();
		//neck.stay();
	}
}
