package frc.robot.auton.sp2;

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
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionTwoOneCubeAndLeaveCommunity extends SequentialCommandGroup {

    public StartingPositionTwoOneCubeAndLeaveCommunity(RobotContainer container, Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth){

        addCommands(

            // Drop preloaded cube on top node

            new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),

            new RollerTimedRelease(roller, .5), // todo change to timed command 

            // Shrink

            new DrawerRetractWithStallDetection(drawer),

            new ElevatorMoveDownWithStallDetection(elevator),

            // Move backward to leave community

            container.createSwerveControllerCommand(createLeaveCommunityTrajectory(container))

            

            
            
        ); 
  
    }

    
    public Trajectory createLeaveCommunityTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS, 0, Rotation2d.fromDegrees(180)),
            container.createReverseTrajectoryConfig());

		return trajectory;
	}

	

   
}