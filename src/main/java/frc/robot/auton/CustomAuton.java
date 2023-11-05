/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
import frc.robot.auton.common.*;
import frc.robot.auton.sp2.*;
//import frc.robot.auton.blue.*;
//import frc.robot.auton.common.*;
import frc.robot.auton.sp4.*;
import frc.robot.auton.sp5.*;
import frc.robot.subsystems.*;

public class CustomAuton extends SequentialCommandGroup {

	String gamePiece;
	String startPosition;
	String mainTarget;
	String cameraOption;
	String sonarOption;
	String autonOption;

	/**
     * Add your docs here.
     * 
     * @param gamePiece_in game piece
	 * @param startPosition_in starting position
     * @param mainTarget_in    main target
     * @param cameraOption_in  camera option
     * @param sonarOption_in   sonar option
     * @param autonOption_in   auton option
    */
    public CustomAuton(String gamePiece_in, String startPosition_in, String mainTarget_in, String cameraOption_in,
            String sonarOption_in, String autonOption_in, SwerveDrivetrain drivetrain, RobotContainer container,
			Elevator elevator, Drawer drawer, Roller roller, Neck neck, Mouth mouth) {

		gamePiece = gamePiece_in;
		startPosition = startPosition_in;
		mainTarget = mainTarget_in;
		cameraOption = cameraOption_in;
		sonarOption = sonarOption_in;
		autonOption = autonOption_in;

		switch (startPosition) {
			case RobotContainer.START_POSITION_1:
				switch (mainTarget) {
					case RobotContainer.MAIN_TARGET_CHARGING_STATION:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CONE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CUBE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CONE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CUBE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_NOWHERE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					default:
						// nothing
						break;
						
				}
				break;
				

			case RobotContainer.START_POSITION_2:
				switch (mainTarget) {
					case RobotContainer.MAIN_TARGET_CHARGING_STATION:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CONE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CUBE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								addCommands(new StartingPositionTwoOneCubeAndLeaveCommunity(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								addCommands(new StartingPositionTwoOneCubeAndLeaveCommunityAndPickupCube(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CONE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new StartingPositionTwoOneCubeAndLeaveCommunity(container, elevator, drawer, roller, neck, mouth));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//addCommands(new StartingPositionTwoTwoCube(container, elevator, drawer, roller, neck, mouth));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CUBE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								addCommands(new StartingPositionTwoTwoCube(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							default:
								// nothing
								break;
						}	
						break;
						
					case RobotContainer.MAIN_TARGET_NOWHERE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;	
					default:
						// nothing
						break;
				}
				break;

			case RobotContainer.START_POSITION_3:
				switch (mainTarget) {
					case RobotContainer.MAIN_TARGET_CHARGING_STATION:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CONE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CUBE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CONE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CUBE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_NOWHERE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					default:
						// nothing
						break;
				}
				break;

			case RobotContainer.START_POSITION_4:
					switch (mainTarget) {
						case RobotContainer.MAIN_TARGET_CHARGING_STATION:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CONE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CUBE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CONE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								addCommands(new StartingPositionFourTwoCubeEngage(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CUBE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_NOWHERE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					default:
						// nothing
						break;
				}
				break;

			case RobotContainer.START_POSITION_5:
				switch (mainTarget) {
					case RobotContainer.MAIN_TARGET_CHARGING_STATION:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CONE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CUBE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								addCommands(new StartingPositionFiveOneCubeAndLeaveCommunity(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								addCommands(new StartingPositionFiveOneCubeAndLeaveCommunity(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CONE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CUBE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								addCommands(new StartingPositionFiveTwoCube(drivetrain, container, elevator, drawer, roller, neck, mouth));
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_NOWHERE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					default:
						// nothing
						break;
				}
				break;

			case RobotContainer.START_POSITION_6:
				switch (mainTarget) {
					case RobotContainer.MAIN_TARGET_CHARGING_STATION:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CONE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_CUBE_NODE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CONE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_TWO_CUBE_NODES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.MAIN_TARGET_NOWHERE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_DROP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_JUST_DROP_CUBE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_DOCK:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CONE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_ALSO_PICKUP_CUBE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					default:
						// nothing
						break;
				}
				break;

            default:{
                //nothing
                break;
            }
		} // end switch
	}
}