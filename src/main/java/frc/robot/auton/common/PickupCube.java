package frc.robot.auton.common;

import java.util.List;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import frc.robot.auton.AutonConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import frc.robot.commands.drawer.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.neck.NeckMoveDownWithStallDetection;
import frc.robot.commands.roller.*;


public class PickupCube extends ParallelCommandGroup{
    
    public PickupCube(RobotContainer container, Neck neck, Roller roller) {

        addCommands(

            new RollerTimedRoll(roller, 2),

            container.createSwerveControllerCommand(createTrajectory3(container.createTrajectoryConfig()))
        
        );


    }
    
    public Trajectory createTrajectory3(TrajectoryConfig config) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_FIRST_CUBE_PICKUP_METERS, -AutonConstants.DISTANCE_FROM_FIRST_KTURN_METERS_TO_AREA_BEFORE_FIRST_CUBE_PICKUP_METERS, new Rotation2d(0)),
			config);

		return trajectory;
	}
}
