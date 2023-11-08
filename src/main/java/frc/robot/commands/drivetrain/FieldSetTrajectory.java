
package frc.robot.commands.drivetrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.RobotContainer;

/**
 * Sets trajectory object of field with specified trajectory.
 */
public class FieldSetTrajectory extends InstantCommand {

	public static final double FIELD_LENGTH_INCHES = 54*12+1; // 54ft 1in
	public static final double FIELD_WIDTH_INCHES = 26*12+7; // 26ft 7in
		
	private RobotContainer	container;
	private Trajectory trajectory;
	private boolean alsoCenterOnField;

	public FieldSetTrajectory(RobotContainer container, Trajectory trajectory, boolean alsoCenterOnField) {
		this.container = container;
		this.trajectory = trajectory;
		this.alsoCenterOnField = alsoCenterOnField;

		//addRequirements(); // nothing to reserve
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("FieldSetTrajectory: initialize");

		if (alsoCenterOnField)
		{
			Translation2d centerFieldTranslation = new Translation2d(Units.inchesToMeters(FIELD_LENGTH_INCHES/2),Units.inchesToMeters(FIELD_WIDTH_INCHES/2)); // mid field
			Rotation2d centerFieldRotation = new Rotation2d(); 
			Pose2d centerFieldPose = new Pose2d(centerFieldTranslation,centerFieldRotation);
			
			Transform2d transform = centerFieldPose.minus(trajectory.getInitialPose());
			Trajectory centeredTrajectory = trajectory.transformBy(transform);

			container.getField().getObject("trajectory").setTrajectory(trajectory);
	
			container.getField().getObject("centeredTrajectory").setTrajectory(centeredTrajectory);
		}
		else
		{
			container.getField().getObject("trajectory").setTrajectory(trajectory);
		}
	}

}
