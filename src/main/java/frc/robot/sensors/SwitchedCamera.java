// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.sensors;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The {@code SwitchedCamera} class contains fields and methods pertaining to the function of the switched camera.
 */
public class SwitchedCamera {

	public synchronized static void setUsbCamera(int camera) {

		// assumes you used "/PiSwitch" as the NT key on the Pi for the switched camera.
		// For reference, 2495 SuffleBoard assumes that names of physical cameras are "rPi Camera 0", "rPi Camera 1" and "rPi Camera 2",
		// and name of switched camera is "Switched Camera 0"
		NetworkTableEntry cameraSelect = NetworkTableInstance.getDefault().getEntry("/PiSwitch");

		if (cameraSelect != null) {
			cameraSelect.setDouble(camera);  // or setString("My Pi Camera Name")
		}
	}

}
