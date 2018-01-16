package org.usfirst.frc.team135.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import java.lang.Math;
import java.util.Optional;

import org.usfirst.frc.team135.robot.commands.DriveStraight;
import org.usfirst.frc.team135.robot.commands.ShiftGears;
import org.usfirst.frc.team135.robot.commands.StopShift;
import org.usfirst.frc.team135.robot.commands.UnshiftGears;
import org.usfirst.frc.team135.robot.commands.DriveToUltrasonicDistance;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public final double JOYSTICK_DEADBAND = 0.15;
	
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
	RIGHT = new Joystick(1);
	LEFT = new Joystick(0);
	MANIP = new Joystick(2);
	
	ConfigureButtonMapping();

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

public double GetManipJoystickY()
{
	double value = SetThreshold(MANIP.getY());
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
	DRIVE_STRAIGHT.whileHeld(new DriveStraight(Optional.ofNullable(null), Optional.ofNullable(null), Optional.ofNullable(null)));
	DISENGAGE.whenPressed(new UnshiftGears());
	ENGAGE.whenPressed(new ShiftGears());
	ZERO.whenPressed(new StopShift());
	

}
}
