package frc.robot.interfaces;

import edu.wpi.first.wpilibj2.command.Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public interface IElevator extends Subsystem {
	// returns the state of the limit switch
	public boolean getForwardLimitSwitchState();

	// returns the state of the reverse limit switch
	public boolean getReverseLimitSwitchState();
	
	// This method should be called to assess the progress of a move
	public boolean tripleCheckMove();

	// extends the elevator asynchronously
	public void moveUp();

	// extends the elevator asynchronously
	public void moveMidway();
	
	// retracts the elevator asynchronously
	public void moveDown();
	
	// returns encoder position
	public double getEncoderPosition();
	
	// returns if elevator is moving
	public boolean isMoving();
	
	// returns if elevator is extending
	public boolean isMovingUp();	

	// returns if elevator is extended
	public boolean isUp();
	
	// returns if elevator is extracted
	public boolean isDown();
	
	// returns if elevator is midway
	public boolean isMidway();

	// returns if elevator is dangerous
	public boolean isDangerous();

	// returns if stalled
	public boolean isStalled();

	// checks if drivetrain might be stalled
	public boolean tripleCheckIfStalled();

	// keeps the elevator in position
	public void stay();	
		
	// stops the elevator, cuts power
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
