// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

import java.util.function.BooleanSupplier;

import frc.robot.subsystems.Mouth;
import frc.robot.subsystems.Neck;

/** The purpose of this class is to check if it's okay to retract the drawer.
 * 
 * It's the case when the mouth and neck are not in the danger zone.
 */
public class MouthAndNeckSafetyCheck implements BooleanSupplier
{
    private Mouth mouth;
    private Neck neck;

    public MouthAndNeckSafetyCheck(Mouth mouth, Neck neck) {
        this.mouth = mouth;
		this.neck = neck;
	}

    @Override
    public boolean getAsBoolean() {
        return !mouth.isDangerous() && !neck.isDangerous();
    }
}
