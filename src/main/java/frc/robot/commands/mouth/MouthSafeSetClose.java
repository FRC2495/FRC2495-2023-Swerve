
package frc.robot.commands.mouth;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;

import frc.robot.util.*;
import frc.robot.commands.DoNothing;
import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Neck;

/**
 *
 */
public class MouthSafeSetClose extends ConditionalCommand {

	public MouthSafeSetClose(Mouth mouth, Neck neck) {
		super(new MouthSetClose(mouth), new DoNothing(), new NeckSafetyCheck(neck));
	}
}
