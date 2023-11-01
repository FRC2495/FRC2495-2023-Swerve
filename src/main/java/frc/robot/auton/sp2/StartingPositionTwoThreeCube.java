package frc.robot.auton.sp2;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.elevator.*;
import frc.robot.commands.neck.NeckMoveDownWithStallDetection;
import frc.robot.commands.neck.NeckSafeMoveUpWithStallDetection;
import frc.robot.commands.drawer.*;
import frc.robot.commands.roller.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionTwoThreeCube extends SequentialCommandGroup {

    public StartingPositionTwoThreeCube(){

        addCommands(

            // Drop preloaded cube on top node
            new ElevatorMoveUpWithStallDetection(null),

            new DrawerExtendWithStallDetection(null),

            new RollerRelease(null), // todo change to timed command 

            // Shrink

            new DrawerSafeRetractWithStallDetection(null, null, null, null),

            new ElevatorMoveDownWithStallDetection(null),

            // Rotate 180 degrees while moving to position before cube

            // Grab mechanism open

            new NeckMoveDownWithStallDetection(null),

            new RollerRoll(null), // todo change to timed command 

            // Move forward to pick up cube

            new NeckSafeMoveUpWithStallDetection(null, null, null),


            // Rotate 180 degrees while moving to shelf

            // Drop cube for mid node

            new RollerRelease(null),
             

            // Move to second cube while rotating 180 degrees

            // Grab mechanism open

            new NeckMoveDownWithStallDetection(null),

            new RollerRoll(null), // todo change to timed command 

            // Move forward to pick up cube


            // Shrink

            new NeckSafeMoveUpWithStallDetection(null, null, null),

            // Move back to shelf while rotating 180 degrees

            // Drop cube

            new NeckMoveDownWithStallDetection(null),

            new RollerRelease(null) // todo change to timed command 
 
            
        ); 
  
    }

    
   


}