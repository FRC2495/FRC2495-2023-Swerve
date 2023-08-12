
package frc.robot.commands.indicator;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Indicator;

/**
 *
 */
public class IndicatorScrollRainbow extends CommandBase {

	private Indicator indicator;

	public IndicatorScrollRainbow(Indicator indicator) {
		this.indicator = indicator;
		addRequirements(indicator);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("IndicatorScrollRainbow: initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		indicator.updateRainbow();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false; // we are never finished
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		System.out.println("IndicatorScrollRainbow: end");
		//indicator.stop();
	}
}
