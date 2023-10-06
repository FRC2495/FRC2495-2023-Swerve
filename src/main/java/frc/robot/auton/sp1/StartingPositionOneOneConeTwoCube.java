package frc.robot.auton.sp1;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionOneOneConeTwoCube extends SequentialCommandGroup {

    public StartingPositionOneOneConeTwoCube(){

        addCommands(

            // drop preloaded cone

            // Rotate 180 degrees while moving to cube

            // Pick up cube

            // Rotate 180 degrees while moving to shelf

            // Drop cube

            // Move to second cube while rotating 180 degrees

            // Pick up cube

            // Move back to shelf while rotating 180 degrees

            // Drop cube
 
            
        ); 
  
    }

    
   


}