
package frc.robot.commands.drawer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drawer;
import frc.robot.subsystems.SwerveDrivetrain;

/**
 *
 */
public class DrawerGamepadControl extends CommandBase {

	private Drawer drawer;
	//private SwerveDrivetrain drivetrain;
	private XboxController gamepad;

	public DrawerGamepadControl(Drawer drawer, SwerveDrivetrain drivetrain, XboxController gamepad) {
		this.drawer = drawer;
		//this.drivetrain = drivetrain;
		this.gamepad = gamepad;
		
		addRequirements(
			drawer,
			drivetrain); // this is needed so that the default drivetrain command does not run at the same time
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrawerGamepadControl: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		drawer.gamepadControl(gamepad);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrawerGamepadControl: end");
		drawer.stop();
	}
}
