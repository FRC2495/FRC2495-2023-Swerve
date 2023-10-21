package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Elevator;

/**
 *
 */
public class ElevatorResetEncoder extends InstantCommand {

    private Elevator elevator;

	public ElevatorResetEncoder(Elevator elevator) {
        this.elevator = elevator;
		addRequirements(elevator);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("ElevatorResetEncoder: initialize");
		elevator.resetEncoder();
	}

}