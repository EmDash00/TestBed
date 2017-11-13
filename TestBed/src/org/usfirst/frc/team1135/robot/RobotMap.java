package org.usfirst.frc.team1135.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	static public class motors
	{
		
	}
	final public int REAR_RIGHT_TALON_ID = 11;
	final public int REAR_LEFT_TALON_ID = 12;
	final public int FRONT_RIGHT_TALON_ID = 13;
	final public int FRONT_LEFT_TALON_ID = 14;
	
	final public int LEFT_SOLENOID_ENGAGE = 1;
	final public int RIGHT_SOLENOID_ENGAGE =3;
	final public int LEFT_SOLENOID_DISENGAGE = 2;
	final public int RIGHT_SOLENOID_DISENGAGE = 4;

	final public int PNEUMATICS_CONTROL_MODULE_ID = 0;
	final public int POWER_DISTRIBUTION_PANEL_ID = 0;
	
	final public boolean RIGHT_SIDE_INVERTED = true;
	final public boolean LEFT_SIDE_INVERTED = false;
	
}
