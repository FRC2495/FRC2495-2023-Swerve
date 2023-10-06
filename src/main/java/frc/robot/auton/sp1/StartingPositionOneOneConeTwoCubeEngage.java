package frc.robot.auton.sp1;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionOneOneConeTwoCubeEngage extends SequentialCommandGroup {

    public StartingPositionOneOneConeTwoCubeEngage(){

        addCommands(

             // drop preloaded cone

            // back up WHILE turning 180

            // pick up cub

            // turn to charge station while going to charge station to get ready to shoot cub

            // shoot cub

            // turn around 180 while moving to another cub right behind

            // pick up cub

            // turn to charge station while going to charge station to get ready to shoot cub

            // shoot cub

            // go engag 
        ); 
  
    }

    
   

}