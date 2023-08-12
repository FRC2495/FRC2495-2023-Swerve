package frc.robot.auton;

public class AutonConstants {

    // Fixed auton distances

    // Starting Position One + Six(?) Distances
    public static final double DISTANCE_FROM_CONE_NODE_TO_AREA_BEFORE_FIRST_TURN = 37;
    public static final double DISTANCE_FROM_AREA_AFTER_FIRST_TURN_TO_AREA_BEFORE_SECOND_TURN = 29;
    public static final double DISTANCE_FROM_AREA_AFTER_SECOND_TURN_TO_AREA_BEFORE_CONE_PICKUP = 120;
    public static final double DISTANCE_FROM_AREA_BEFORE_CONE_PICKUP_TO_CONE_PICKUP = 30;
    public static final double DISTANCE_FROM_AREA_AFTER_SECOND_TURN_TO_CONE_PICKUP = 144.5; // the total of previous two constants
    public static final double DISTANCE_FROM_CONE_PICKUP_TO_AREA_BEFORE_THIRD_TURN = 134.5;
    public static final double DISTANCE_FROM_AREA_AFTER_THIRD_TURN_TO_AREA_BEFORE_FOURTH_TURN = 21;
    public static final double DISTANCE_FROM_AREA_AFTER_FOURTH_TURN_TO_CONE_NODE = 8;

    public static final double DISTANCE_FROM_NODE_TO_OUTSIDE_COMMUNITY = 134+26;
    public static final double DISTANCE_FROM_OUTSIDE_COMMUNITY_TO_SECOND_CONE_PICKUP = 25;

    // Starting Position Three + Four Distances
    public static final double DISTANCE_FROM_NODE_TO_DOCK = 30; // todo put proper value
    public static final double DISTANCE_FROM_START_OF_CHARGING_STATION_TO_DOCKED_AT_CHARGING_STATION = 10; // todo put proper value
    public static final double DISTANCE_FROM_DOCK_TO_OUTSIDE_COMMUNITY = 100; // todo put proper value
    public static final double DISTANCE_FROM_OUTSIDE_COMMUNITY_TO_BEFORE_DOCK = 90; // todo put proper value
    public static final double DISTANCE_FROM_DOCK_NEAR_NODE_TO_AREA_BEFORE_CONE_PICKUP = 70; // todo put proper value
    public static final double DISTANCE_FROM_CONE_PICKUP_TO_AREA_BEFORE_DOCK = 85; // todo put proper value
    public static final double DISTANCE_FROM_DOCK_NEAR_CONE_PICKUP_TO_AREA_NEAR_CONE_NODE = 60;
    public static final double DISTANCE_FROM_AREA_NEAR_CONE_NODE_TO_CONE_NODE = 30;


    // Fixed auton angles

    // Starting Position One + Six(?) Angles
    public static final int ANGLE_BETWEEN_CONE_NODE_AND_AREA_AFTER_FIRST_TURN = 180;
    public static final int ANGLE_BETWEEN_AREA_AFTER_FIRST_TURN_AND_CONE_PICKUP = 15;
    public static final int ANGLE_BETWEEN_AREA_BEFORE_THIRD_TURN_AND_TOWARDS_CONE_NODE_FIRST_PART = 90;
    public static final int ANGLE_BETWEEN_AREA_BEFORE_THIRD_TURN_AND_TOWARDS_CONE_NODE_SECOND_PART = 115; // the total of this and previous angle is supposed to be 205
    public static final int ANGLE_BETWEEN_AREA_BEFORE_FOURTH_TURN_AND_CONE_NODE = 25;
    public static final int ANGLE_BETWEEN_CONE_NODE_AND_CONE_PICKUP = 165;
    public static final int ANGLE_BETWEEN_CONE_PICKUP_AND_CONE = 10;
    public static final int ANGLE_BETWEEN_RIGHT_CONE_NODE_AND_CONE_PICKUP = 153;

}
