package frc.robot.commands.mouth;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Mouth.Position;

// To set mouth open
public class MouthOpen extends CommandBase {

	
	private Mouth mouth;

	public MouthOpen(Mouth mouth) {	
		this.mouth = mouth;
		addRequirements(mouth);
	}

	// Called once when the command executes
	@Override
	public void initialize() {
		System.out.println("MouthOpen: initialize");
		mouth.setPosition(Position.OPEN);
	}

}