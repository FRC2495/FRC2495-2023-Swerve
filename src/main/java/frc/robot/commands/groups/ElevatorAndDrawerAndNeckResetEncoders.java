
package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Drawer;
import frc.robot.subsystems.Neck;

import frc.robot.commands.elevator.*;
import frc.robot.commands.drawer.*;
import frc.robot.commands.neck.*;

/**
 *
 */
public class ElevatorAndDrawerAndNeckResetEncoders extends SequentialCommandGroup {

	public ElevatorAndDrawerAndNeckResetEncoders(Elevator elevator, Drawer drawer, Neck neck) {

		addCommands(
			new ElevatorResetEncoder(elevator),
			new DrawerResetEncoder(drawer),
			new NeckResetEncoder(neck));
	} 

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

}
