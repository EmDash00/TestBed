package org.usfirst.frc.team1135.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
	
	final static public int REAR_RIGHT_TALON_ID = 13;
	final static public int REAR_LEFT_TALON_ID = 11;
	final static public int FRONT_RIGHT_TALON_ID = 14;
	final static public int FRONT_LEFT_TALON_ID = 13;
	
	final static public int LEFT_SOLENOID_ENGAGE = 3;
	final static public int RIGHT_SOLENOID_ENGAGE = 0;
	final static public int LEFT_SOLENOID_DISENGAGE = 2;
	final static public int RIGHT_SOLENOID_DISENGAGE = 1;

	final static public int PNEUMATICS_CONTROL_MODULE_ID = 0;
	final static public int POWER_DISTRIBUTION_PANEL_ID = 0;
	
	final static public boolean RIGHT_SIDE_INVERTED = true;
	final static public boolean LEFT_SIDE_INVERTED = false;
	
}
