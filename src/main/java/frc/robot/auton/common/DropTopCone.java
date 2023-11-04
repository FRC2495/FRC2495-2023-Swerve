package frc.robot.auton.common;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.commands.drawer.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.roller.*;
import frc.robot.subsystems.*;


public class DropTopCone extends SequentialCommandGroup{
    
    public DropTopCone(RobotContainer container, Elevator elevator, Drawer drawer, Roller roller) {

        addCommands(
            
            new ElevatorMoveUpWithStallDetection(elevator),

            new DrawerExtendWithStallDetection(drawer),

            new RollerRelease(roller)
        
        );


    }

}
