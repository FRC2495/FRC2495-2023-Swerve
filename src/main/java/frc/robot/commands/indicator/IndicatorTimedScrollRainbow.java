/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.indicator;

import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.subsystems.Indicator;

/**
 * Add your docs here.
 */
public class IndicatorTimedScrollRainbow extends WaitCommand {

	private Indicator indicator;

	/**
	 * Add your docs here.
	 */
	public IndicatorTimedScrollRainbow(Indicator indicator, double timeout) {
		super(timeout);

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
		System.out.println("IndicatorTimedScrollRainbow: initialize");
		super.initialize();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		indicator.updateRainbow();
	}

	// Called once after timeout
	@Override
	public void end(boolean interrupted) {
		System.out.println("IndicatorTimedScrollRainbow: end");
		//indicator.stop();
		super.end(interrupted);
	}
}
