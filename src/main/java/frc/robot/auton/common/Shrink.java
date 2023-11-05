package frc.robot.auton.common;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.commands.drawer.*;
import frc.robot.commands.elevator.*;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class Shrink extends SequentialCommandGroup {

    public Shrink(RobotContainer container, Elevator elevator, Drawer drawer){

        addCommands(

            new DrawerRetractWithStallDetection(drawer),

            new ElevatorMoveDownWithStallDetection(elevator)
            
        ); 
  
    }

   
}