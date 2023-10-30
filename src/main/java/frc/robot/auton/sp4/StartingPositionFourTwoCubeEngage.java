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
import frc.robot.auton.common.*;
import frc.robot.commands.drawer.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.neck.*;
import frc.robot.commands.roller.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionFourTwoCubeEngage extends SequentialCommandGroup {

    public StartingPositionFourTwoCubeEngage(RobotContainer container) {

        addCommands(

            // Drop preloaded cube
            new ElevatorMoveUpWithStallDetection(null),

            new DrawerExtendWithStallDetection(null),

            new RollerRelease(null),

            // Shrink
            new DrawerSafeRetractWithStallDetection(null, null, null, null),

            new ElevatorMoveDownWithStallDetection(null),

            // Move to cube directly over charge station
            container.createSwerveControllerCommand(createTrajectory(container.createTrajectoryConfig())),

            // Get ready to pick up the cube
            new DrawerExtendWithStallDetection(null),

            new NeckMoveDownWithStallDetection(null),

            new RollerRoll(null),

            // Move forward to pick up cube


            // Shrink
            new DrawerSafeRetractWithStallDetection(null, null, null, null),

            new NeckSafeMoveUpWithStallDetection(null, null, null),

            // Rotate 180 degrees and move back to shelf over charge station


            // Shoot cube
            new RollerRelease(null)

        ); 
  
    }

    public Trajectory createTrajectory(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(Units.inchesToMeters(AutonConstants.DISTANCE_FROM_START_OF_CHARGING_STATION_TO_DOCKED_AT_CHARGING_STATION + AutonConstants.DISTANCE_FROM_DOCK_TO_OUTSIDE_COMMUNITY), 0, new Rotation2d(0)),
			config);

		return trajectory;
	}
   

}