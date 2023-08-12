package frc.robot;

/**
 * Contains the definitions of all the ports
 */
public class Ports {

		// IP (v4) addresses
		// The purpose of this section is to serve as a reminder of what static IP (v4) addresses are used so they are consistent
		// between the competition and practice robots.
		//
		// The radio is automatically set to 10.24.95.1
		// The Rio is set to static 10.24.95.2, mask 255.255.255.0
		// The Limelight is set to 10.24.95.11, mask 255.255.255.0, gateway 10.24.95.1
		// but note that pressing the reset button will revert to DHCP.
		// The Raspberry Pi running FRCVision is set to static 10.24.95.12, mask 255.255.255.0, gateway 10.24.95.1, DNS blank
		//
		// If a device cannot be accessed (e.g. because its address was somehow obtained via DHCP and mDNS is not working),
		// use Angry IP Scanner to find it!


		/**
		 * Digital ports
		 */
		public static class Digital{
			public static final int CHECK_PRESSURE = 0;
			
		}
		
		/**
		 * Analog ports
		 */
		public static class Analog{
			public static final int SONAR = 3;
			public static final int PRESSURE_SENSOR = 1;
		}
		
		/**
		 * Relays
		 */
		public static class Relay{
			public static final int COMPRESSOR_RELAY = 0;
		}
		
		/**
		 * CAN Ids
		 */
		public static class CAN{
			/* 2017 robot
			public static final int RIGHT_REAR = 3;
			public static final int RIGHT_FRONT = 4;
			public static final int LEFT_REAR = 1;
			public static final int LEFT_FRONT = 2;
			public static final int SPIN = 5;
			public static final int CLIMB = 6;
			public static final int BASIN = 7;
			public static final int PCM = 8;
			public static final int PDP = 0;*/
			
			// 2019 robot
			/*
			public static final int RIGHT_FRONT = 1;
			public static final int RIGHT_REAR = 2;
			public static final int LEFT_FRONT = 3;
			public static final int LEFT_REAR = 4;
			public static final int FRONT_CENTER = 5; // unused
			public static final int REAR_CENTER = 6; // unused
			public static final int ELEVATOR = 7;
			public static final int SHOOTER_LEFT = 8;
			public static final int SHOOTER_RIGHT = 9;
			public static final int HINGE = 10;
			public static final int WINCH = 11; 
			public static final int HAB_ELEVATOR = 12;
			public static final int SPINNER = 13;
			public static final int PCM = 9;
			public static final int PDP = 0;
			*/

			//2020 Robot
			/*public static final int RIGHT_FRONT = 1;
			public static final int RIGHT_REAR = 2;
			public static final int LEFT_FRONT = 3;
			public static final int LEFT_REAR = 4;
			public static final int GRASPER = 5;
			public static final int HINGE_MASTER = 6;
			public static final int HINGE_FOLLOWER = 7;
			public static final int SPINNER = 8;
			public static final int PCM = 9;
			public static final int PDP = 0;
			public static final int WINCH_MASTER = 10;
			public static final int WINCH_FOLLOWER = 11;*/

			//2022 Robot
			/*public static final int RIGHT_FRONT = 1;
			public static final int RIGHT_REAR = 2;
			public static final int LEFT_FRONT = 3;
			public static final int LEFT_REAR = 4;
			public static final int GRASPER = 5;
			public static final int HINGE_MASTER = 6;
			public static final int HINGE_FOLLOWER = 7;
			//public static final int SPINNER = 8;
			public static final int PCM = 9;
			public static final int PDP = 0;
			public static final int FRONT_ARM_MASTER_UNUSED = 10;
			public static final int FRONT_ARM_REAL_MASTER = 11;
			public static final int REAR_ARM_MASTER_UNUSED = 32;
			public static final int REAR_ARM_REAL_MASTER = 33;
			public static final int FRONT_ELBOW_MASTER = 13;
			public static final int FRONT_ELBOW_FOLLOWER = 12;
			public static final int REAR_ELBOW_MASTER = 30;
			public static final int REAR_ELBOW_FOLLOWER = 31;
			public static final int SHOOTER = 18;
			public static final int FEEDER = 19;*/

			//2023 Robot
			public static final int RIGHT_FRONT = 1;
			public static final int RIGHT_REAR = 2;
			public static final int LEFT_FRONT = 3;
			public static final int LEFT_REAR = 4;
			//public static final int GRASPER = 5;
			public static final int SHOULDER_MASTER = 6;
			public static final int SHOULDER_FOLLOWER = 7;
			//public static final int SPINNER = 8;
			public static final int PCM = 1;
			public static final int PDP = 0;	
			public static final int ARM_MASTER = 10;
			public static final int ARM_FOLLOWER = 11;
			public static final int ROTATOR_MASTER = 12;
			public static final int ROTATOR_FOLLOWER = 13;
			public static final int JACK_MASTER = 14;
		}
		
		/**
		 * USB ports
		 */
		public static class USB{
			public static final int RIGHT = 0;
			public static final int LEFT = 1;
			public static final int GAMEPAD = 2;
		}
		
		/**
		 * PCM ports
		 */
		public static class PCM{
			/* 2017 robot
			public static final int INTAKE_IN = 0;
			public static final int INTAKE_OUT = 1;
			public static final int INTAKE_DOWN = 2;
			public static final int INTAKE_UP = 3;
			public static final int GEAR_IN = 5;
			public static final int GEAR_OUT = 4;
			public static final int BASIN_DOWN = 6;
			public static final int BASIN_UP = 7;*/
			
			// 2019 robot
			/*public static final int KICKER_OUT = 0;
			public static final int KICKER_IN = 1;		
			public static final int SUCKER_EXHALE = 2;
			public static final int SUCKER_INHALE= 3;
			public static final int EJECTOR_RETRACTED = 5;
			public static final int EJECTOR_EXTENDED = 4;			
			public static final int HOOK_UP = 7;
			public static final int HOOK_DOWN = 6;*/

			// 2020 robot
			/*public static final int GEAR_HIGH = 0;
			public static final int GEAR_LOW = 1;
			public static final int WINCH_STOPPER_STOPPED = 3;
			public static final int WINCH_STOPPER_FREE = 2; 
			public static final int WINCH_LOCK_LOCKED = 4;
			public static final int WINCH_LOCK_UNLOCKED = 5; 
			public static final int PUSHER_UP = 7; // cannot be used at same time as spinner raiser
			public static final int PUSHER_DOWN = 6;
			public static final int SPINNER_RAISER_UP = 7;
			public static final int SPINNER_RAISER_DOWN = 6;*/

			// 2022 robot
			/*public static final int GEAR_HIGH = 0;
			public static final int GEAR_LOW = 1;
			public static final int FRONT_ELBOWS_OPEN = 2;
			public static final int FRONT_ELBOWS_CLOSED = 3;
			public static final int REAR_ELBOWS_OPEN = 4;
			public static final int REAR_ELBOWS_CLOSED = 5;*/

			// 2023 robot
			public static final int GEAR_HIGH = 1;
			public static final int GEAR_LOW = 0;
			public static final int CLAW_CLOSED = 3;
			public static final int CLAW_OPEN = 2;
			public static final int BRAKE_ENGAGED = 5;
			public static final int BRAKE_RELEASED = 4;
		 		}

		/**
		 * PWM ports
		 */
		public static class PWM {
			public static final int LED_STRIP = 9;
		}

		/**
		 * USB cameras
		 */
		public static class UsbCamera {
			public static final int PRIMARY_CAMERA = 0;
			public static final int BOTTOM_CAMERA = 1;
			public static final int TOP_CAMERA = 2;
		}
}
