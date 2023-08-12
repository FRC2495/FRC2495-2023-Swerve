
package frc.robot.commands.camera;

import edu.wpi.first.wpilibj2.command.InstantCommand;

//import frc.robot.Robot;
import frc.robot.interfaces.ICamera.LedMode;
import frc.robot.sensors.LimelightCamera;

/**
 *
 */
public class CameraSetLedMode extends InstantCommand {

	private LedMode ledMode;

	public CameraSetLedMode(LedMode ledMode_in) {
		ledMode = ledMode_in;
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("CameraSetLedMode: initialize");
		LimelightCamera.setLedMode(ledMode);
	}

}
