package frc.robot.commands.neck;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Neck;

/**
 *
 */
public class NeckResetEncoder extends InstantCommand {

    private Neck neck;

	public NeckResetEncoder(Neck neck) {
        this.neck = neck;
		addRequirements(neck);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("NeckResetEncoder: initialize");
		neck.resetEncoder();
	}

}