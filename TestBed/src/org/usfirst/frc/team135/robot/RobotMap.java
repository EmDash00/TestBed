package org.usfirst.frc.team135.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
	
	public static final int REAR_RIGHT_TALON_ID = 14;
	public static final int REAR_LEFT_TALON_ID = 12;
	public static final int FRONT_RIGHT_TALON_ID = 13;
	public static final int FRONT_LEFT_TALON_ID = 11;
	
	public static final int LEFT_SOLENOID_ENGAGE = 3;
	public static final int RIGHT_SOLENOID_ENGAGE = 0;
	public static final int LEFT_SOLENOID_DISENGAGE = 2;
	public static final int RIGHT_SOLENOID_DISENGAGE = 1;

	public static final int PNEUMATICS_CONTROL_MODULE_ID = 0;
	public static final int POWER_DISTRIBUTION_PANEL_ID = 0;
	
	public static final boolean RIGHT_SIDE_INVERTED = true;
	public static final boolean LEFT_SIDE_INVERTED = false;
	
	public class conversions
	{
		public static final float LIDAR2INCH;
	}
	
	
}
