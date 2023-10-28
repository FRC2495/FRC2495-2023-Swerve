
package frc.robot.commands.neck;

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
public class NeckSafeMoveUpWithStallDetection extends ConditionalCommand {

	public NeckSafeMoveUpWithStallDetection(Neck neck, Mouth mouth, XboxController gamepad) {
		super(new NeckMoveUpWithStallDetection(neck), new GamepadTimedRumble(gamepad, true, 1), new MouthSafetyCheck(mouth));
	}
}
