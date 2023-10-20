package frc.robot.interfaces;

import edu.wpi.first.wpilibj2.command.Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public interface IElevator extends Subsystem {
	// returns the state of the limit switch
	public boolean getLimitSwitchState();

	// returns the state of the reverse limit switch
	public boolean getReverseLimitSwitchState();
	
	// This method should be called to assess the progress of a move
	public boolean tripleCheckMove();

	// extends the arm asynchronously
	public void extend();

	// extends the arm asynchronously
	// public void extendPickup();

	// extends the arm asynchronously
	public void extendMidway();
	
	// retracts the arm asynchronously
	public void retract();
	
	// returns encoder position
	public double getEncoderPosition();
	
	// returns if arm is moving
	public boolean isMoving();
	
	// returns if arm is extending
	public boolean isExtending();	

	// returns if arm is extended
	public boolean isExtended();
	
	// returns if arm is extracted
	public boolean isRetracted();
	
	// returns if arm is midway
	public boolean isMidway();

	// returns if arm is dangerous
	public boolean isDangerous();

	// returns if arm is dangerous for shoulder at floor
	// public boolean isDangerousForShoulderAtFloor();

	// returns if stalled
	public boolean isStalled();

	// checks if drivetrain might be stalled
	public boolean tripleCheckIfStalled();

	// keeps the arm in position
	public void stay();	
		
	// stops the arm, cuts power
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
