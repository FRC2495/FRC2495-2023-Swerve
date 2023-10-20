
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Roller;

/**
 *
 */
public class RollerRoll extends InstantCommand {

	private Roller roller;

	public RollerRoll(Roller roller) {
		this.roller = roller;
		addRequirements(roller);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("RollerRoll: initialize");
		roller.roll();
	}

}
