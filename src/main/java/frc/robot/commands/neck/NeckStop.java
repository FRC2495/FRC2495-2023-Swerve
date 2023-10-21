
package frc.robot.commands.neck;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Neck;

/**
 *
 */
public class NeckStop extends InstantCommand {

    private Neck neck;
	public NeckStop(Neck neck) {
        this.neck = neck;
		addRequirements(neck);
	} 

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("NeckStop: initialize");
		neck.stop();
	}

}