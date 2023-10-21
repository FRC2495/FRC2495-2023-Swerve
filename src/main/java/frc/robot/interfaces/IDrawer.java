package frc.robot.interfaces;

import edu.wpi.first.wpilibj2.command.Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public interface IDrawer extends Subsystem {
	// returns the state of the limit switch
	public boolean getForwardLimitSwitchState();

	// returns the state of the reverse limit switch
	public boolean getReverseLimitSwitchState();
	
	// This method should be called to assess the progress of a move
	public boolean tripleCheckMove();

	// extends the drawer asynchronously
	public void extend();

	// extends the drawer asynchronously
	public void extendMidway();
	
	// retracts the drawer asynchronously
	public void retract();
	
	// returns encoder position
	public double getEncoderPosition();
	
	// returns if drawer is moving
	public boolean isMoving();
	
	// returns if drawer is extending
	public boolean isExtending();	

	// returns if drawer is extended
	public boolean isExtended();
	
	// returns if drawer is extracted
	public boolean isRetracted();
	
	// returns if drawer is midway
	public boolean isMidway();

	// returns if drawer is dangerous
	public boolean isDangerous();

	// returns if stalled
	public boolean isStalled();

	// checks if drivetrain might be stalled
	public boolean tripleCheckIfStalled();

	// keeps the drawer in position
	public void stay();	
		
	// stops the drawer, cuts power
	public void stop();

	// NOTE THAT THIS METHOD WILL IMPACT BOTH OPEN AND CLOSED LOOP MODES
	public void setNominalAndPeakOutputs(double peakOutput);

	// for debug purpose only
	public void joystickControl(Joystick joystick);

	public void gamepadControl(XboxController gamepad);
	
	public double getTarget();

	// MAKE SURE THAT YOU ARE NOT IN A CLOSED LOOP CONTROL MODE BEFORE CALLING THIS METHOD.
	// OTHERWISE THIS IS EQUIVALENT TO MOVING TO THE DISTANCE TO THE CURRENT ZERO IN REVERSE! 
	public void resetEncoder();
}
