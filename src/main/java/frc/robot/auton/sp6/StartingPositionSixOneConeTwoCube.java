package frc.robot.auton.sp6;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionSixOneConeTwoCube extends SequentialCommandGroup {

    public StartingPositionSixOneConeTwoCube(){

        addCommands(

        // Drop preloaded cone
        
        // Move to first cube while rotating 180 degrees

        // Pick up cube

        // Move into community and shoot the cube

        // turn to second cube and move there

        // Pick up cube

        // Turn to charge station and move into community

        // Shoot the cube

        // Engage
            
        ); 
  
    }

    
   

}