package frc.robot.auton.common;

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
public class CompletelyLeaveCommunity extends SequentialCommandGroup {

    public CompletelyLeaveCommunity(RobotContainer container){

        addCommands(

            container.createSwerveControllerCommand(createLeaveCommunityTrajectory(container.createReverseTrajectoryConfig()))

            
        ); 
  
    }

    
    public Trajectory createLeaveCommunityTrajectory(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS, 0, Rotation2d.fromDegrees(180)),
			config);

		return trajectory;
	}

	

   
}