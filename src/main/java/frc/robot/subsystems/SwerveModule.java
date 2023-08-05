// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
//import edu.wpi.first.wpilibj.AnalogEncoder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.SparkMaxAbsoluteEncoder.Type;
import com.revrobotics.SparkMaxPIDController;
//import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;

import frc.robot.Constants.SwerveModuleConstants;
import frc.robot.sensors.ThriftyEncoder;

/**
 * The {@code SwerveModule} class contains fields and methods pertaining to the function of a swerve module.
 */
public class SwerveModule {
	private final CANSparkMax m_drivingSparkMax;
	private final CANSparkMax m_turningSparkMax;

	private final RelativeEncoder m_drivingEncoder;
	private final /*AbsoluteEncoder*/RelativeEncoder m_turningEncoder;
	private final ThriftyEncoder m_turningAbsoluteEncoder;

	private final SparkMaxPIDController m_drivingPIDController;
	private final SparkMaxPIDController m_turningPIDController;

	private double m_chassisAngularOffset = 0;
	private SwerveModuleState m_desiredState = new SwerveModuleState(0.0, new Rotation2d());

	/**
	 * Constructs a SwerveModule and configures the driving and turning motor,
	 * encoder, and PID controller.
	 */
	public SwerveModule(int drivingCANId, int turningCANId, int turningAnalogPort, double chassisAngularOffset) {
		m_drivingSparkMax = new CANSparkMax(drivingCANId, MotorType.kBrushless);
		m_turningSparkMax = new CANSparkMax(turningCANId, MotorType.kBrushless);

		// Factory reset, so we get the SPARKS MAX to a known state before configuring
		// them. This is useful in case a SPARK MAX is swapped out.
		m_drivingSparkMax.restoreFactoryDefaults();
		m_turningSparkMax.restoreFactoryDefaults();

		// Setup encoders and PID controllers for the driving and turning SPARKS MAX.
		m_drivingEncoder = m_drivingSparkMax.getEncoder();
		m_turningEncoder = m_turningSparkMax/*.getAbsoluteEncoder(Type.kDutyCycle)*/.getEncoder();
		m_turningAbsoluteEncoder = new ThriftyEncoder(turningAnalogPort);

		m_drivingPIDController = m_drivingSparkMax.getPIDController();
		m_turningPIDController = m_turningSparkMax.getPIDController();
		m_drivingPIDController.setFeedbackDevice(m_drivingEncoder);
		m_turningPIDController.setFeedbackDevice(m_turningEncoder);

		// Apply position and velocity conversion factors for the driving encoder. The
		// native units for position and velocity are rotations and RPM, respectively,
		// but we want meters and meters per second to use with WPILib's swerve APIs.
		m_drivingEncoder.setPositionConversionFactor(SwerveModuleConstants.kDrivingEncoderPositionFactor);
		m_drivingEncoder.setVelocityConversionFactor(SwerveModuleConstants.kDrivingEncoderVelocityFactor);

		// Apply position and velocity conversion factors for the turning encoder. We
		// want these in radians and radians per second to use with WPILib's swerve
		// APIs.
		m_turningEncoder.setPositionConversionFactor(SwerveModuleConstants.kTurningEncoderPositionFactor);
		m_turningEncoder.setVelocityConversionFactor(SwerveModuleConstants.kTurningEncoderVelocityFactor);

		// Invert the turning encoder, since the output shaft rotates in the opposite direction of
		// the steering motor in the MAXSwerve Module.
		/*m_turningEncoder.setInverted(ModuleConstants.kTurningEncoderInverted);*/
		m_turningSparkMax.setInverted(true);

		// Enable PID wrap around for the turning motor. This will allow the PID
		// controller to go through 0 to get to the setpoint i.e. going from 350 degrees
		// to 10 degrees will go through 0 rather than the other direction which is a
		// longer route.
		// TODO REMOVE COMMENTS TO ENABLE WRAPPING
		//m_turningPIDController.setPositionPIDWrappingEnabled(true);
		//m_turningPIDController.setPositionPIDWrappingMinInput(ModuleConstants.kTurningEncoderPositionPIDMinInput);
		//m_turningPIDController.setPositionPIDWrappingMaxInput(ModuleConstants.kTurningEncoderPositionPIDMaxInput);

		// Set the PID gains for the driving motor. Note these are example gains, and you
		// may need to tune them for your own robot!
		m_drivingPIDController.setP(SwerveModuleConstants.kDrivingP);
		m_drivingPIDController.setI(SwerveModuleConstants.kDrivingI);
		m_drivingPIDController.setD(SwerveModuleConstants.kDrivingD);
		m_drivingPIDController.setFF(SwerveModuleConstants.kDrivingFF);
		m_drivingPIDController.setOutputRange(SwerveModuleConstants.kDrivingMinOutput,
			SwerveModuleConstants.kDrivingMaxOutput);

		// Set the PID gains for the turning motor. Note these are example gains, and you
		// may need to tune them for your own robot!
		m_turningPIDController.setP(SwerveModuleConstants.kTurningP);
		m_turningPIDController.setI(SwerveModuleConstants.kTurningI);
		m_turningPIDController.setD(SwerveModuleConstants.kTurningD);
		m_turningPIDController.setFF(SwerveModuleConstants.kTurningFF);
		m_turningPIDController.setOutputRange(SwerveModuleConstants.kTurningMinOutput,
			SwerveModuleConstants.kTurningMaxOutput);

		m_drivingSparkMax.setIdleMode(SwerveModuleConstants.kDrivingMotorIdleMode);
		m_turningSparkMax.setIdleMode(SwerveModuleConstants.kTurningMotorIdleMode);
		m_drivingSparkMax.setSmartCurrentLimit(SwerveModuleConstants.kDrivingMotorCurrentLimit);
		m_turningSparkMax.setSmartCurrentLimit(SwerveModuleConstants.kTurningMotorCurrentLimit);

		// Save the SPARK MAX configurations. If a SPARK MAX browns out during
		// operation, it will maintain the above configurations.
		m_drivingSparkMax.burnFlash();
		m_turningSparkMax.burnFlash();

		m_chassisAngularOffset = chassisAngularOffset; // TODO REMOVE ALL REFS TO ANGULAR OFFSET
		m_desiredState.angle = new Rotation2d(m_turningEncoder.getPosition());
		m_drivingEncoder.setPosition(0);
	}

	/**
	 * Returns the current state of the module.
	 *
	 * @return The current state of the module.
	 */
	public SwerveModuleState getState() {
		// Apply chassis angular offset to the encoder position to get the position
		// relative to the chassis.
		return new SwerveModuleState(m_drivingEncoder.getVelocity(),
			new Rotation2d(m_turningEncoder.getPosition() - m_chassisAngularOffset)); // TODO REMOVE ALL REFS TO ANGULAR OFFSET
	}

	/**
	 * Returns the current position of the module.
	 *
	 * @return The current position of the module.
	 */
	public SwerveModulePosition getPosition() {
		// Apply chassis angular offset to the encoder position to get the position
		// relative to the chassis.
		return new SwerveModulePosition(
			m_drivingEncoder.getPosition(),
			new Rotation2d(m_turningEncoder.getPosition() - m_chassisAngularOffset)); // TODO REMOVE ALL REFS TO ANGULAR OFFSET
	}

	/**
	 * Sets the desired state for the module.
	 *
	 * @param desiredState Desired state with speed and angle.
	 */
	public void setDesiredState(SwerveModuleState desiredState) {
		// Apply chassis angular offset to the desired state.
		SwerveModuleState correctedDesiredState = new SwerveModuleState();
		correctedDesiredState.speedMetersPerSecond = desiredState.speedMetersPerSecond;
		//correctedDesiredState.angle = desiredState.angle.plus(Rotation2d.fromRadians(m_chassisAngularOffset)); // WE SKIP THIS STEP
		correctedDesiredState.angle = desiredState.angle; // we do not need to deal with angular offsets

		// Optimize the reference state to avoid spinning further than 90 degrees.
		SwerveModuleState optimizedDesiredState = SwerveModuleState.optimize(correctedDesiredState,
			new Rotation2d(m_turningEncoder.getPosition()));

		// Command driving and turning SPARKS MAX towards their respective setpoints.
		// TODO SWITCH BACK TO OPTIMIZED PATHS AFTER REMOVING CHASSIS ANGULAR OFFSET WHICH IS NOT APPLICABLE
		m_drivingPIDController.setReference(/*optimizedD*/desiredState.speedMetersPerSecond, CANSparkMax.ControlType.kVelocity);
		m_turningPIDController.setReference(/*optimizedD*/desiredState.angle.getRadians(), CANSparkMax.ControlType.kPosition);

		m_desiredState = desiredState;
	}

	/** Zeroes all the SwerveModule relative encoders. */
	public void resetEncoders() {

		m_drivingEncoder.setPosition(0); // arbitrarily set driving encoder to zero

		// temp
		//m_turningAbsoluteEncoder.resetVirtualPosition();
		// the reading and setting of the calibrated absolute turning encoder values is done in the Drivetrain's constructor

		m_turningSparkMax.set(0); // no moving during reset of relative turning encoder

		m_turningEncoder.setPosition(m_turningAbsoluteEncoder.getVirtualPosition()); // set relative position based on virtual absolute position
	}

	/** Calibrates the virtual position (i.e. sets position offset) of the absolute encoder. */
	public void calibrateVirtualPosition(double angle)
	{
		m_turningAbsoluteEncoder.setPositionOffset(angle);
	}

	public RelativeEncoder getDrivingEncoder()
	{
		return m_drivingEncoder;
	}

	public RelativeEncoder getTurningEncoder()
	{
		return m_turningEncoder;
	}

	public ThriftyEncoder getTurningAbsoluteEncoder()
	{
		return m_turningAbsoluteEncoder;
	}

	public SwerveModuleState getDesiredState()
	{
		return m_desiredState;
	}

}
