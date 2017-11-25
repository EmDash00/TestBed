package org.usfirst.frc.team1135.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import java.lang.Math;

import org.usfirst.frc.team1135.robot.commands.ExampleCommand;
import org.usfirst.frc.team1135.robot.commands.ShiftGears;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final int MAX_NUMBER_JOYSTICKS = 2;
	public final int MAX_NUMBER_BUTTONS = 12;
	
	public final int LEFT_JOYSTICK = 0;
	public final int RIGHT_JOYSTICK = 1;
	
	public final int ENGAGE_SHIFTER_BUTTON = 1; //trigger
	public boolean gearShiftOn = false;
	
	public final double JOYSTICK_DEADBAND = 0.15;
	
	public Joystick[] joystick = new Joystick[MAX_NUMBER_JOYSTICKS];
	public JoystickButton[][] button = new JoystickButton[MAX_NUMBER_JOYSTICKS][MAX_NUMBER_BUTTONS];
	
public void InitializeJoysticks()
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

public boolean GetButton(int joysticknumber, int buttonnumber)
{
	return button[joysticknumber][buttonnumber].get();
}
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

public double GetJoystickY(int joysticknumber)
{
	double convertedValue = SetThreshold(joystick[joysticknumber].getY());
	return convertedValue;
}

public void ConfigureButtonMapping()
{
	button[RIGHT_JOYSTICK][ENGAGE_SHIFTER].whenPressed(new ShiftGears());
}
}
