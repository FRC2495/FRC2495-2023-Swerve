package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Ports;


/**
 * The {@code Claw} class contains fields and methods pertaining to the function of the mouth.
 */
public class Mouth extends SubsystemBase {
	
	static final int WAIT_MS = 1000;
	
    DoubleSolenoid lockedNot;
    
    public enum Position {
		CLOSED, // The mouth is closed
		OPEN, // The mouth is open
		UNKNOWN;
	}

	public Mouth() {
		// the double solenoid valve will send compressed air from the tank wherever needed
		lockedNot = new DoubleSolenoid(Ports.CAN.PCM, PneumaticsModuleType.REVPH, Ports.PCM.MOUTH_CLOSED, Ports.PCM.MOUTH_OPEN); // make sure ports are properly sets in Ports.java	
	}
	
	/*@Override
	public void initDefaultCommand() {

	}*/

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	public void setPosition(Position pos) //Telling the piston to be in the selected position 
	{
		switch(pos)
		{
			case CLOSED: //Telling the solenoid to have the piston go up
			{
				lockedNot.set(DoubleSolenoid.Value.kReverse); // adjust direction if needed
				break;
			}
			case OPEN: //Telling the solenoid to have the piston go down
			{
				lockedNot.set(DoubleSolenoid.Value.kForward); // adjust direction if needed
				break;
			}
			default:
			{
				// do nothing
			}
		}
	}

	public Position getPosition() //Getting the current gear
	{
		DoubleSolenoid.Value value = lockedNot.get();
		
		switch(value)
		{
			case kReverse: //Checking if the piston is in the kReverse position (high)
			{
				return Position.CLOSED;
			}
			case kForward: //Checking if the piston is in the kFoward position (low)
			{
				return Position.OPEN;
			}
			default: //gear unknown
			{
				return Position.UNKNOWN;
			}
		}
	}

	public boolean isDangerous() {
		return getPosition() == Position.CLOSED;
	}

}