package org.usfirst.frc.team135.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import java.lang.Math;

import org.usfirst.frc.team135.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/*public final int MAX_NUMBER_JOYSTICKS = 2;
	public final int MAX_NUMBER_BUTTONS = 12;
	
	public final int LEFT_JOYSTICK = 0;
	public final int RIGHT_JOYSTICK = 1;
	
	public final int ENGAGE_SHIFTER_BUTTON = 7; //trigger
	public final int DISENGAGE_SHIFTER_BUTTON = 8;
	public boolean gearShiftOn = false; */
	
	public final double JOYSTICK_DEADBAND = 0.15;
	
	/*public Joystick[] joystick;
	public JoystickButton[][] button;*/
	
	Joystick RIGHT, LEFT, MANIP;
	JoystickButton ENGAGE, DISENGAGE, ZERO;
	
	JoystickButton DRIVE_STRAIGHT;
	
	public static OI instance;
	
public static OI getInstance()
{		
	if (instance == null)		
	{
		instance = new OI();
	}
	return instance;
}

private OI()
{
	/*joystick = new Joystick[MAX_NUMBER_JOYSTICKS];
	button = new JoystickButton[MAX_NUMBER_JOYSTICKS][MAX_NUMBER_BUTTONS];
	InitializeJoysticks();
	ConfigureButtonMapping();*/
	RIGHT = new Joystick(1);
	LEFT = new Joystick(0);
	MANIP = new Joystick(2);
	
	ConfigureButtonMapping();

}

/*public void InitializeJoysticks()
{

	for (int i=0;i <=MAX_NUMBER_JOYSTICKS; i++)
	{
		joystick[i] = new Joystick(i);
		for (int k=0; k<=MAX_NUMBER_BUTTONS; k++)
		{
			button[i][k] = new JoystickButton(joystick[i], k);
		}
	}
}
*/
/*public boolean GetButton(int joysticknumber, int buttonnumber)
{
	boolean value = button[joysticknumber][buttonnumber].get();
	return value;
}*/
public double SetThreshold(double joystickValue)
{
	if (Math.abs(joystickValue) <= JOYSTICK_DEADBAND)
	{
		return 0;
	}
	else 
	{
		return joystickValue;
	}
}

public double GetLeftJoystickY()
{
	double value = SetThreshold(LEFT.getY());
	return value;
}

public double GetRightJoystickY()
{
	double value = SetThreshold(RIGHT.getY());
	return value;

	
}

public void ConfigureButtonMapping()
{
	ENGAGE = new JoystickButton(MANIP, 7);
	DISENGAGE = new JoystickButton(MANIP, 8);
	ZERO = new JoystickButton(MANIP, 10);
	DRIVE_STRAIGHT = new JoystickButton(RIGHT, 5);
	AssignButtons();
}

public void AssignButtons()
{
	//DRIVE_STRAIGHT.whileHeld(new DriveStraight());
	DISENGAGE.whenPressed(new UnshiftGears());
	ENGAGE.whenPressed(new ShiftGears());
	ZERO.whenPressed(new StopShift());
}
}
