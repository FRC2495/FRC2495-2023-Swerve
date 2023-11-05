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
public class StartingPositionOneOneConeTwoCube extends SequentialCommandGroup {

    public StartingPositionOneOneConeTwoCube(RobotContainer container, Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth){

        addCommands(

            // drop preloaded cone
            new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),

            new RollerRelease(roller),

            // Shrink

            new DrawerSafeRetractWithStallDetection(drawer, mouth, neck, container.getCopilotGamepad()),

            new ElevatorMoveDownWithStallDetection(elevator),

            // Rotate 180 degrees while moving to cube

            // Grab mechanism open

            new NeckMoveDownWithStallDetection(neck),

            new RollerRoll(roller), // todo change to timed command 

            // Move forward to pick up cube

            new NeckSafeMoveUpWithStallDetection(neck, mouth, container.getCopilotGamepad()),

            // Rotate 180 degrees while moving to shelf

            // Drop cube
            new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),

            new RollerRelease(roller), // todo change to timed command 

            // Move to second cube while rotating 180 degrees

            // Grab mechanism open

            new NeckMoveDownWithStallDetection(neck),

            new RollerRoll(roller), // todo change to timed command 

            // Move forward to pick up cube

            // Move back to shelf while rotating 180 degrees

            // Drop cube

            new RollerRelease(roller)
 
            
        ); 
  
    }

    
   


}