
package frc.robot.commands.drawer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.subsystems.Drawer;
import frc.robot.subsystems.SwerveDrivetrain;

/**
 *
 */
public class DrawerJoystickControl extends CommandBase {

	private Drawer drawer;
	//private SwerveDrivetrain drivetrain;
	private Joystick joystick;

	public DrawerJoystickControl(Drawer drawer, SwerveDrivetrain drivetrain, Joystick joystick) {
		this.drawer = drawer;
		//this.drivetrain = drivetrain;
		this.joystick = joystick;
		
		addRequirements(
			drawer,
			drivetrain); // this is needed so that the default drivetrain command does not run at the same time
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrawerJoystickControl: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		drawer.joystickControl(joystick);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("DrawerJoystickControl: end");
		drawer.stop();
	}
}
