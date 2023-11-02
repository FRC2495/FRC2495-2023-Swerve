
package frc.robot.commands.neck;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Neck;

/**
 *
 */
public class NeckGamepadControl extends CommandBase {

	private Neck neck;
	private XboxController gamepad;

	public NeckGamepadControl(Neck neck, XboxController gamepad) {
		this.neck = neck;
		this.gamepad = gamepad;
		
		addRequirements(
			neck);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("NeckGamepadControl: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		neck.gamepadControl(gamepad);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("NeckGamepadControl: end");
		neck.stop();
	}
}
