package frc.robot.sensors;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

import edu.wpi.first.math.filter.LinearFilter;


/**
 * The {@code HMAccelerometer} class contains fields and methods pertaining to the function of the accelerometer.
 */
public class HMAccelerometer {
	
	static final double FLAT_TILT_THRESH_DEGREES = 6.0;
	static final double SUPER_FLAT_TILT_THRESH_DEGREES = 3.0;
	
	private BuiltInAccelerometer accel;
	private LinearFilter filterZ;
	private LinearFilter filterAR;
	
	public HMAccelerometer() {
		accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
		
		filterZ = LinearFilter.movingAverage(5); // filter over n iterations
		filterAR = LinearFilter.movingAverage(5); // filter over n iterations
	}
	
	
	public double getAccelX() {
		return accel.getX();
	}

	public double getAccelY() {
		return accel.getY();
	}
	
	public double getAccelZ() {
		return accel.getZ();
	}

	public double getFilteredAccelZ() {
		return filterZ.calculate(accel.getZ());
	}
	
	public double getTilt() {
		return Math.toDegrees(Math.acos(Math.min(getAccelZ(),1.0)/1.0)); // assumes getAccelZ() returns 1.0 when straight
	}

	public double getFilteredTilt() {
		return Math.toDegrees(Math.acos(Math.min(getFilteredAccelZ(),1.0)/1.0)); // assumes getAccelZ() returns 1.0 when straight
	}

	public double getAccurateTilt() {
		// https://www.thierry-lequeu.fr/data/AN3461.pdf
		// https://www.analog.com/en/app-notes/an-1057.html
		try {
			return Math.toDegrees(Math.atan(Math.sqrt(Math.pow(getAccelX(),2) + Math.pow(getAccelY(),2)) / getAccelZ()));
		}
		catch (ArithmeticException e) {
            return 90; // if accelz is zero, we are dead
        }
	}

	public double getAccuratePitch() {
		// https://www.thierry-lequeu.fr/data/AN3461.pdf
		// https://www.analog.com/en/app-notes/an-1057.html
		try {
			return Math.toDegrees(Math.atan(getAccelX() / Math.sqrt(Math.pow(getAccelY(),2) + Math.pow(getAccelZ(),2))));
		}
		catch (ArithmeticException e) {
            return 90; // if denominator is zero, we are dead
        }
	}

	public double getAccurateRoll() {
		// https://www.thierry-lequeu.fr/data/AN3461.pdf
		// https://www.analog.com/en/app-notes/an-1057.html
		try {
			return Math.toDegrees(Math.atan(getAccelY() / Math.sqrt(Math.pow(getAccelX(),2) + Math.pow(getAccelZ(),2))));
		}
		catch (ArithmeticException e) {
            return 90; // if denominator is zero, we are dead
        }
	}

	public double getFilteredAccurateRoll() {
		return filterAR.calculate(getAccurateRoll());
	}
	
	
	/**
	 * Indicates if the support onto which the accelerometer is attached is flat
	 * 
	 * @return true if the support onto which the accelerometer is attached is flat, false otherwise
	 */
	public boolean isFlat() {
		return getAccurateTilt() < FLAT_TILT_THRESH_DEGREES;
	}

	/**
	 * Indicates if the support onto which the accelerometer is attached is super flat
	 * 
	 * @return true if the support onto which the accelerometer is attached is super flat, false otherwise
	 */
	public boolean isSuperFlat() {
		return getAccurateTilt() < SUPER_FLAT_TILT_THRESH_DEGREES;
	}
	
}
