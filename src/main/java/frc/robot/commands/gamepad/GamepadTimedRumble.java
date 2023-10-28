/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.gamepad;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * Add your docs here.
 */
public class GamepadTimedRumble extends WaitCommand {

	private XboxController gamepad;
	private boolean m_rumble;

	/**
	 * Add your docs here.
	 */
	public GamepadTimedRumble(XboxController gamepad, boolean rumble, double timeout) {
		super(timeout);

		this.gamepad = gamepad;
		m_rumble = rumble;
		
		// ControllerBase is not a real subsystem, so no need to reserve it
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		System.out.println("GamepadTimedRumble: initialize");
		super.initialize();

		gamepad.setRumble(RumbleType.kBothRumble, m_rumble?1:0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		// nothing
	}

	// Called once after timeout
	@Override
	public void end(boolean interrupted) {
		System.out.println("GamepadTimedRumble: end");
		
		gamepad.setRumble(RumbleType.kBothRumble, 0); // done
		
		super.end(interrupted);
	}
}
