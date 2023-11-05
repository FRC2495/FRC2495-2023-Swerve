package frc.robot.auton.common;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;
import frc.robot.subsystems.*;

// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class CompletelyLeaveCommunity extends SequentialCommandGroup {

    public CompletelyLeaveCommunity(SwerveDrivetrain drivetrain, RobotContainer container) {

        addCommands(
            new MoveInReverse(drivetrain, container, AutonConstants.DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY_METERS)            
        ); 
  
    }
   
}