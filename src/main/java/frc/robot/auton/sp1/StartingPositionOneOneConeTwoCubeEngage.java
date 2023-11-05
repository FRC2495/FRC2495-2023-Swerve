package frc.robot.auton.sp1;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.commands.drawer.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.neck.*;
import frc.robot.commands.roller.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionOneOneConeTwoCubeEngage extends SequentialCommandGroup {

    public StartingPositionOneOneConeTwoCubeEngage(RobotContainer container, Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth){

        addCommands(

            // Drop preloaded cube
            new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),
 
            new RollerRelease(roller),
 
            // Shrink
            new DrawerSafeRetractWithStallDetection(drawer, mouth, neck, container.getCopilotGamepad()),
 
            new ElevatorMoveDownWithStallDetection(elevator),
 
            // Move to cube
             
             
            // Get ready to pick up the cube
 
            new NeckMoveDownWithStallDetection(neck),
 
            new RollerRoll(roller),
 
            // Move forward to pick up cube
 
 
            // Shrink
 
            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad()),
 
            // Shoot cube
            new RollerRelease(roller), // todo change to more powerful

            // Turn 180


            // Get ready to pick up the cube
            new DrawerExtendWithStallDetection(drawer),
 
            new NeckMoveDownWithStallDetection(neck),

            new RollerRoll(roller),

            // Move forward to pick up cube

            // Turn 180 and move so robot is touching charge station

            // Shoot cube
            new RollerRelease(roller), // todo change to more powerful
            
            // Turn 180


            // Get ready to pick up the cube
            new DrawerExtendWithStallDetection(drawer),
 
            new NeckMoveDownWithStallDetection(neck),

            new RollerRoll(roller),

            // Move forward to pick up cube

            // Engage


            // Shoot cube
            new RollerRelease(roller) // todo change to more powerful

        ); 
  
    }

    
   

}