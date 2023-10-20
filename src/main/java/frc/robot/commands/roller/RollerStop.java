
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Roller;

/**
 *
 */
public class RollerStop extends InstantCommand {

	private Roller roller;

	public RollerStop(Roller roller) {
		this.roller = roller;
		addRequirements(roller);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("RollerStop: initialize");
		roller.stop();
	
	}

}
