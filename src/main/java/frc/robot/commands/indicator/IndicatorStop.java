
package frc.robot.commands.indicator;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Indicator;

/**
 *
 */
public class IndicatorStop extends InstantCommand {

	//private Indicator indicator;

	public IndicatorStop(Indicator indicator) {
		//this.indicator = indicator;
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
		//System.out.println("IndicatorStop: initialize");
		//indicator.stop(); // requiring the indicator should be enough to interrupt a long-running command
	}

}
