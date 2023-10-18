package frc.robot.subsystems;

import java.util.Timer;
import java.util.TimerTask;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import frc.robot.Ports;


/**
 * The {@code Compressor} class contains fields and methods pertaining to the function of the compressor.
 */
public class Compressor extends SubsystemBase {
	//private DigitalInput checkPressure;
	edu.wpi.first.wpilibj.Compressor checkPressure;
	private Relay relay;
	private static final long CHECK_TIME_MS = 20;
	private Timer timer = new Timer();
	

	/**
	 * <pre>
	 * public Compressor()
	 * </pre>
	 * Constructs a new {@code Compressor} with a set {@code DigitalInput} and {@code Relay}.
	 */
	public Compressor() {
		//checkPressure = new DigitalInput(Ports.Digital.CHECK_PRESSURE);
		checkPressure = new edu.wpi.first.wpilibj.Compressor(Ports.CAN.PCM, PneumaticsModuleType.REVPH);
		relay = new Relay(Ports.Relay.COMPRESSOR_RELAY);
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	/**
	 * <pre>
	 * public void checkCompressor()
	 * </pre>
	 * Schedules a task to check the compressor.
	 */
	public void checkCompressor() {
		timer.schedule(new CheckCompressorTask(checkPressure, relay), CHECK_TIME_MS, CHECK_TIME_MS);
	}
	
	/**
	 * The {@code CheckCompressorTask} is a {@code TimerTask} used to check if the compressor can shoot, and act accordingly.
	 */
	private class CheckCompressorTask extends TimerTask {
		//private DigitalInput _checkPressure;
		edu.wpi.first.wpilibj.Compressor _checkPressure;
		//private AnalogInput inputSwitch;
		private Relay _relay;

		/**
		 * <pre>
		 * public CheckCompressorTask(DigitalInput dI,
		 *                            Relay r)
		 * </pre>
		 * Constructs a new {@code CheckCompressorTask} with a specified {@code DigitalInput} and {@code Relay} to use
		 * for checking the compressor.
		 * @param dI the {@code DigitalInput} to use to check the compressor
		 * @param r the {@code Relay} to use to manipulate the compressor
		 */
		//public CheckCompressorTask(DigitalInput dI, Relay r) {
		public CheckCompressorTask(edu.wpi.first.wpilibj.Compressor compressor, Relay r) {	
			//_checkPressure = dI;
			_checkPressure = compressor;
			_relay = r;
		}

		@Override
		public void run() {
			if (_checkPressure/*.get()*/.getPressureSwitchValue() == /*true*/false) {
				SmartDashboard.putBoolean("Check pressure ", _checkPressure/*.get()*/.getPressureSwitchValue());
				_relay.set(Relay.Value.kOff);
				SmartDashboard.putBoolean("Compressor relay ", false);
			} else {
				SmartDashboard.putBoolean("Check pressure ", _checkPressure/*.get()*/.getPressureSwitchValue());
				_relay.set(Relay.Value.kForward);
				SmartDashboard.putBoolean("Compressor relay ", true);
			}
		}

	}
}