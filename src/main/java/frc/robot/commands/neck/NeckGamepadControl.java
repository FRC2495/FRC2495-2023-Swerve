
package frc.robot.commands.neck;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Neck;
import frc.robot.subsystems.SwerveDrivetrain;

/**
 *
 */
public class NeckGamepadControl extends CommandBase {

	private Neck neck;
	//private SwerveDrivetrain drivetrain;
	private XboxController gamepad;

	public NeckGamepadControl(Neck neck, SwerveDrivetrain drivetrain, XboxController gamepad) {
		this.neck = neck;
		//this.drivetrain = drivetrain;
		this.gamepad = gamepad;
		
		addRequirements(
			neck,
			drivetrain); // this is needed so that the default drivetrain command does not run at the same time
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
