
package frc.robot.commands.mouth;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;

import frc.robot.util.*;
//import frc.robot.commands.DoNothing;
import frc.robot.commands.gamepad.GamepadRumble;
import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Neck;

/**
 *
 */
public class MouthSafeSetClose extends ConditionalCommand {

	public MouthSafeSetClose(Mouth mouth, Neck neck, XboxController gamepad) {
		super(new MouthSetClose(mouth), new GamepadRumble(gamepad,true), new NeckSafetyCheck(neck));
	}
}
