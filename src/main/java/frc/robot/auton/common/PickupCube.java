package frc.robot.auton.common;

import java.util.List;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import frc.robot.auton.AutonConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import frc.robot.commands.drivetrain.*;
import frc.robot.commands.roller.*;


public class PickupCube extends ParallelCommandGroup{
    
    public PickupCube(SwerveDrivetrain drivetrain, RobotContainer container, Neck neck, Roller roller) {

        addCommands(

            new RollerTimedRoll(roller, .5),

            new DrivetrainSwerveRelative(drivetrain, container, createAreaBeforeCubePickupTrajectory(container))        
        );
    }
    
    public Trajectory createAreaBeforeCubePickupTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_FROM_AREA_BEFORE_FIRST_CUBE_PICKUP_TO_CUBE_PICKUP_METERS, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}
}
