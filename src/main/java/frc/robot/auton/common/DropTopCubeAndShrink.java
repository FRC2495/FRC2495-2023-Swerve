package frc.robot.auton.common;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.subsystems.*;


public class DropTopCubeAndShrink extends SequentialCommandGroup{
    
    public DropTopCubeAndShrink(RobotContainer container, Elevator elevator, Drawer drawer, Roller roller) {

        addCommands(
            
            new DropTopCube(container, elevator, drawer, roller),

            new Shrink(container, elevator, drawer)
        );

    }

}
