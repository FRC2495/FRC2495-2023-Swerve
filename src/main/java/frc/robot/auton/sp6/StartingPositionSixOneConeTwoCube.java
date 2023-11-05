package frc.robot.auton.sp6;

import frc.robot.commands.elevator.*;
import frc.robot.commands.neck.*;
import frc.robot.commands.drawer.*;
import frc.robot.commands.roller.*;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionSixOneConeTwoCube extends SequentialCommandGroup {

    public StartingPositionSixOneConeTwoCube(){

        addCommands(

        // drop preloaded cone
        new ElevatorMoveUpWithStallDetection(null),

        new DrawerExtendWithStallDetection(null),

        new RollerRelease(null),

        // Shrink

        new DrawerSafeRetractWithStallDetection(null, null, null, null),

        new ElevatorMoveDownWithStallDetection(null),

        // Rotate 180 degrees while moving to cube

        // Grab mechanism open

        new NeckMoveDownWithStallDetection(null),

        new RollerRoll(null), // todo change to timed command 

        // Move forward to pick up cube

        new NeckSafeMoveUpWithStallDetection(null, null, null),

        // Rotate 180 degrees while moving to shelf

        // Drop cube
        new ElevatorMoveUpWithStallDetection(null),

        new DrawerExtendWithStallDetection(null),

        new RollerRelease(null), // todo change to timed command 

        // Move to second cube while rotating 180 degrees

        // Grab mechanism open

        new NeckMoveDownWithStallDetection(null),

        new RollerRoll(null), // todo change to timed command 

        // Move forward to pick up cube

        // Move back to shelf while rotating 180 degrees

        // Drop cube

        new RollerRelease(null)

            
        ); 
  
    }

    
   

}