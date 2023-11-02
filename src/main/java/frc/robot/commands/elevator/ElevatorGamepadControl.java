
package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Elevator;

/**
 *
 */
public class ElevatorGamepadControl extends CommandBase {

	private Elevator elevator;
	private XboxController gamepad;

	public ElevatorGamepadControl(Elevator elevator, XboxController gamepad) {
		this.elevator = elevator;
		this.gamepad = gamepad;
		
		addRequirements(
			elevator);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("ElevatorGamepadControl: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		elevator.gamepadControl(gamepad);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("ElevatorGamepadControl: end");
		elevator.stop();
	}
}
