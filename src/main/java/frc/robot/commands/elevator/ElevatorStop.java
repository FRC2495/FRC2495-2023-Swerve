
package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Elevator;

/**
 *
 */
public class ElevatorStop extends InstantCommand {

    private Elevator elevator;
	public ElevatorStop(Elevator elevator) {
        this.elevator = elevator;
		addRequirements(elevator);
	} 

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("ElevatorStop: initialize");
		elevator.stop();
	}

}