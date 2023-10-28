package frc.robot.auton.sp4;

import java.util.List;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionFourTwoCubeEngage extends SequentialCommandGroup {

    public StartingPositionFourTwoCubeEngage(RobotContainer container) {

        addCommands(

            // Drop preloaded cube

            // Move to cube directly over charge station
            container.createSwerveControllerCommand(createTrajectory(container.createTrajectoryConfig()))

            // Pick up the cube
            
            // Rotate 180 degrees and move back to shelf over charge station

            // Drop cube
            
            // Engage by moving backwards onto charge station
        ); 
  
    }

    public Trajectory createTrajectory(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(new Translation2d(Units.inchesToMeters(AutonConstants.DISTANCE_FROM_START_OF_CHARGING_STATION_TO_DOCKED_AT_CHARGING_STATION), 0)),
			// End straight ahead of where we started, facing forward
			new Pose2d(Units.inchesToMeters(AutonConstants.DISTANCE_FROM_START_OF_CHARGING_STATION_TO_DOCKED_AT_CHARGING_STATION + AutonConstants.DISTANCE_FROM_DOCK_TO_OUTSIDE_COMMUNITY), 0, new Rotation2d(0)),
			config);

		return trajectory;
	}
   

}