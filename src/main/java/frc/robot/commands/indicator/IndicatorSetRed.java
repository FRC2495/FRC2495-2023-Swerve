
package frc.robot.commands.indicator;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Indicator;

/**
 *
 */
public class IndicatorSetRed extends InstantCommand {

	private Indicator indicator;

	public IndicatorSetRed(Indicator indicator) {
		this.indicator = indicator;
		addRequirements(indicator);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		//System.out.println("IndicatorSetRed: initialize");
		indicator.setRed();
	}

}
