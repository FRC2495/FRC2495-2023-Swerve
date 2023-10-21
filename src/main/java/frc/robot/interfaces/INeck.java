package frc.robot.interfaces;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Subsystem;

public interface INeck extends Subsystem {

	// returns the state of the limit switch
	public boolean getReverseLimitSwitchState();

	public boolean getForwardLimitSwitchState();
	
	// This method should be called to assess the progress of a move
	public boolean tripleCheckMove();
	
	public void moveUp();

	public void moveMidway();
	
	public void moveDown();

	public double getPosition();

	public double getEncoderPosition();

	public boolean isMoving();
	
	public boolean isUp();
	
	public boolean isDown();
	
	public boolean isMidway();

	public boolean isDangerous();

	// return if stalled
	public boolean isStalled();

	// checks if might be stalled
	public boolean tripleCheckIfStalled();

	public void stay();
	
	public void stop();
		
	// for debug purpose only
	public void joystickControl(Joystick joystick);

	public void gamepadControl(XboxController gamepad);

	public double getTarget();
	
	// MAKE SURE THAT YOU ARE NOT IN A CLOSED LOOP CONTROL MODE BEFORE CALLING THIS METHOD.
	// OTHERWISE THIS IS EQUIVALENT TO MOVING TO THE DISTANCE TO THE CURRENT ZERO IN REVERSE! 
	public void resetEncoder();
}
