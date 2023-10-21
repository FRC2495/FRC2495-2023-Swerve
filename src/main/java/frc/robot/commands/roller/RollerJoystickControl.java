
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.subsystems.Roller;
import frc.robot.subsystems.SwerveDrivetrain;

/**
 *
 */
public class RollerJoystickControl extends CommandBase {

	private Roller roller;
	//private SwerveDrivetrain drivetrain;
	private Joystick joystick;

	public RollerJoystickControl(Roller roller, SwerveDrivetrain drivetrain, Joystick joystick) {
		this.roller = roller;
		//this.drivetrain = drivetrain;
		this.joystick = joystick;
		
		addRequirements(
			roller,
			drivetrain); // this is needed so that the default drivetrain command does not run at the same time
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("RollerJoystickControl: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		roller.joystickControl(joystick);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("RollerJoystickControl: end");
		roller.stop();
	}
}
