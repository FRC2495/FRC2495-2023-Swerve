package frc.robot.commands.drawer;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.Drawer;

/**
 *
 */
public class DrawerResetEncoder extends InstantCommand {

    private Drawer drawer;

	public DrawerResetEncoder(Drawer drawer) {
        this.drawer = drawer;
		addRequirements(drawer);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("DrawerResetEncoder: initialize");
		drawer.resetEncoder();
	}

}