package org.usfirst.frc.team1135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import org.usfirst.frc.team1135.robot.RobotMap;

import org.usfirst.frc.team1135.robot.commands.StopShift;
import org.usfirst.frc.team1135.robot.commands.ShiftGears;
import org.usfirst.frc.team1135.robot.commands.UnshiftGears;


public class Gearshifters extends Subsystem implements RobotMap {

private DoubleSolenoid rightSolenoid, leftSolenoid;

private Compressor compressor;

private static Gearshifters instance;

public void initDefaultCommand() {
	
	setDefaultCommand(new StopShift());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

public static Gearshifters getInstance()
{
	if (instance == null)
	{
		instance = new Gearshifters();
	}
	return instance;
}

private Gearshifters()
{
	rightSolenoid = new DoubleSolenoid(RIGHT_SOLENOID_ENGAGE, RIGHT_SOLENOID_DISENGAGE);
	leftSolenoid = new DoubleSolenoid(LEFT_SOLENOID_ENGAGE, LEFT_SOLENOID_DISENGAGE);
	compressor = new Compressor(0);
	compressor.setClosedLoopControl(true);
	rightSolenoid.set(DoubleSolenoid.Value.kOff);
	leftSolenoid.set(DoubleSolenoid.Value.kOff);
	
}

public void SolenoidForward(boolean active)
{
	if (active)
	{
	rightSolenoid.set(DoubleSolenoid.Value.kForward);
	leftSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	else
	{
		rightSolenoid.set(DoubleSolenoid.Value.kOff);
		leftSolenoid.set(DoubleSolenoid.Value.kOff);
	}
}
public void SolenoidBackwards(boolean active)
{
	if (active)
	{
		rightSolenoid.set(DoubleSolenoid.Value.kReverse);
		leftSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	else 
	{
		rightSolenoid.set(DoubleSolenoid.Value.kOff);
		leftSolenoid.set(DoubleSolenoid.Value.kOff);
}
}
public void SolenoidOff()
{
	rightSolenoid.set(DoubleSolenoid.Value.kOff);
	leftSolenoid.set(DoubleSolenoid.Value.kOff);
}


}

