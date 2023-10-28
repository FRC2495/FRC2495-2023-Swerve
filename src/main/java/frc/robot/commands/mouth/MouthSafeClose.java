
package frc.robot.commands.mouth;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;

import frc.robot.util.*;
//import frc.robot.commands.DoNothing;
import frc.robot.commands.gamepad.GamepadTimedRumble;
import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Neck;

/**
 *
 */
public class MouthSafeClose extends ConditionalCommand {

	public MouthSafeClose(Mouth mouth, Neck neck, XboxController gamepad) {
		super(new MouthClose(mouth), new GamepadTimedRumble(gamepad, true, 1), new NeckSafetyCheck(neck));
	}
}
