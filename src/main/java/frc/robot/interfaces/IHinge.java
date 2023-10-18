package frc.robot.interfaces;

import edu.wpi.first.wpilibj.Joystick;

public interface IHinge {

	// returns the state of the limit switch
	public boolean getLimitSwitchState();
	
	// homes the hinge
	// This is done in two steps:
	// step 1: if not already at the switch, we go down slowly until we hit the limit switch.
	// step 2: we go back up a little and mark the position as the virtual/logical zero.

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

	public void stay();
	
	public void stop();
		
	// for debug purpose only
	public void joystickControl(Joystick joystick);
	
	public double getTarget();
	

}
