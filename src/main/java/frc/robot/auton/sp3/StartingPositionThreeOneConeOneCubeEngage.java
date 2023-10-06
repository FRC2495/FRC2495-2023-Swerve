package frc.robot.auton.sp3;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionThreeOneConeOneCubeEngage extends SequentialCommandGroup {

    public StartingPositionThreeOneConeOneCubeEngage(){

        addCommands(

            // Drop preloaded cone

            // Move to cube directly over charge station

            // Pick up the cube
            
            // Rotate 180 degrees and move back to shelf over charge station

            // Drop cube
            
            // Engage by moving backwards onto charge station
        ); 
  
    }

    
   

}