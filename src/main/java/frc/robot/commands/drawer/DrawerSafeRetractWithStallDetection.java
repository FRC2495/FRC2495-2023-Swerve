
package frc.robot.commands.drawer;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;

import frc.robot.util.*;
//import frc.robot.commands.DoNothing;
import frc.robot.commands.gamepad.GamepadRumble;
import frc.robot.subsystems.Drawer;
import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Neck;

/**
 *
 */
public class DrawerSafeRetractWithStallDetection extends ConditionalCommand {

	public DrawerSafeRetractWithStallDetection(Drawer drawer, Mouth mouth, Neck neck, XboxController gamepad) {
		super(new DrawerRetractWithStallDetection(drawer), new GamepadRumble(gamepad,true), new MouthAndNeckSafetyCheck(mouth, neck));
	}
}
