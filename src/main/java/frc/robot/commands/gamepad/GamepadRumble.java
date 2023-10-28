
package frc.robot.commands.gamepad;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.InstantCommand;


/**
 *
 */
public class GamepadRumble extends InstantCommand {

	private XboxController gamepad;
	private boolean m_rumble;

	public GamepadRumble(XboxController gamepad, boolean rumble) {

		this.gamepad = gamepad;
		m_rumble = rumble;

		// ControllerBase only supports instant commands, so no need to reserve it
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		
		System.out.println("GamepadRumble: initialize");
		gamepad.setRumble(RumbleType.kBothRumble, m_rumble?1:0);
	}

}
