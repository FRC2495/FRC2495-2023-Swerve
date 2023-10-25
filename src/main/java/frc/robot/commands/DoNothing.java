
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This command does nothing.
 */
public class DoNothing extends InstantCommand {
	/**
	 * Add your docs here.
	 */
	public DoNothing() {
		super();
	}

	// Called once when the command executes
	@Override
	public void initialize() {
		System.out.println("DoNothing: initialize");
	}

}