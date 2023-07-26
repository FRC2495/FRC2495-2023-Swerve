// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;

/** Add your docs here. */
public class ThriftyEncoder
{
    private AnalogInput analogInput;
    private boolean inverted;

    public ThriftyEncoder(int port){
        this.analogInput = new AnalogInput(port);
        this.inverted = false;
    }

    public double getPosition() {
        return (inverted ? -1.0 : 1.0) * ((analogInput.getAverageVoltage() / RobotController.getVoltage5V()) * (Math.PI * 2) - Math.PI);
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
        
    }
}