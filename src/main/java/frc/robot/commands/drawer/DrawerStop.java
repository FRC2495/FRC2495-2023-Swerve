
package frc.robot.commands.drawer;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Drawer;

/**
 *
 */
public class DrawerStop extends InstantCommand {

    private Drawer drawer;
	public DrawerStop(Drawer drawer) {
        this.drawer = drawer;
		addRequirements(drawer);
	} 

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("DrawerStop: initialize");
		drawer.stop();
	}

}