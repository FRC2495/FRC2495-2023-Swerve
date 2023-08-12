
package frc.robot.commands.camera;

import edu.wpi.first.wpilibj2.command.InstantCommand;

//import frc.robot.Robot;
import frc.robot.sensors.SwitchedCamera;

/**
 *
 */
public class SwitchedCameraSetUsbCamera extends InstantCommand {

	private int camera;

	public SwitchedCameraSetUsbCamera(int camera_in) {
		camera = camera_in;
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("SwitchedCameraSetUsbCamera: initialize");
		SwitchedCamera.setUsbCamera(camera);
	}

}
