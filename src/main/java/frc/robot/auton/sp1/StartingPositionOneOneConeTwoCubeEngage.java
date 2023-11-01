package frc.robot.auton.sp1;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

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

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionOneOneConeTwoCubeEngage extends SequentialCommandGroup {

    public StartingPositionOneOneConeTwoCubeEngage(RobotContainer container){

        addCommands(

            // Drop preloaded cube
            new ElevatorMoveUpWithStallDetection(null),

            new DrawerExtendWithStallDetection(null),
 
            new RollerRelease(null),
 
            // Shrink
            new DrawerSafeRetractWithStallDetection(null, null, null, null),
 
            new ElevatorMoveDownWithStallDetection(null),
 
            // Move to cube
             
             
            // Get ready to pick up the cube
 
            new NeckMoveDownWithStallDetection(null),
 
            new RollerRoll(null),
 
            // Move forward to pick up cube
 
 
            // Shrink
 
            new NeckSafeMoveUpWithStallDetection(null, null, null),
 
            // Shoot cube
            new RollerRelease(null), // todo change to more powerful

            // Turn 180


            // Get ready to pick up the cube
            new DrawerExtendWithStallDetection(null),
 
            new NeckMoveDownWithStallDetection(null),

            new RollerRoll(null),

            // Move forward to pick up cube

            // Turn 180 and move so robot is touching charge station

            // Shoot cube
            new RollerRelease(null), // todo change to more powerful
            
            // Turn 180


            // Get ready to pick up the cube
            new DrawerExtendWithStallDetection(null),
 
            new NeckMoveDownWithStallDetection(null),

            new RollerRoll(null),

            // Move forward to pick up cube

            // Engage

            
            // Shoot cube
            new RollerRelease(null) // todo change to more powerful

        ); 
  
    }

    
   

}