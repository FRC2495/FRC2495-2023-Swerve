// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;

/**
 * The {@code ThriftyEncoder} class contains fields and methods pertaining to the function of the absolute encoder.
 */
public class ThriftyEncoder
{
	private AnalogInput analogInput;
	private boolean inverted;
	private double positionOffset;

	public ThriftyEncoder(int port) {
		this.analogInput = new AnalogInput(port);
		this.inverted = false;
		this.positionOffset = 0.0;
	}

	public double getPosition() {
		return (inverted ? -1.0 : 1.0) * ((analogInput.getAverageVoltage() / RobotController.getVoltage5V()) * (Math.PI * 2) - Math.PI);
	}

	public void setInverted(boolean inverted) {
		this.inverted = inverted;       
	}

	public void setPositionOffset(double offset) {
		positionOffset = offset;
	}

	public double getPositionOffset() {
		return positionOffset;
	}

	public double getVirtualPosition() {
		return getPosition() - positionOffset;
	}

	public void resetVirtualPosition() {
		positionOffset = getPosition();
	}

}