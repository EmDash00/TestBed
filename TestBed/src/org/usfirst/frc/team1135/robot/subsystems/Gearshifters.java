package org.usfirst.frc.team1135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import org.usfirst.frc.team1135.robot.commands.ShiftGears;
import org.usfirst.frc.team1135.robot.Robot;


/**
 *
 */
public class Gearshifters extends Subsystem {

final DoubleSolenoid rightSolenoid = new DoubleSolenoid(Robot.robotmap.RIGHT_SOLENOID_ENGAGE, Robot.robotmap.RIGHT_SOLENOID_DISENGAGE);
final DoubleSolenoid leftSolenoid = new DoubleSolenoid(Robot.robotmap.LEFT_SOLENOID_ENGAGE, Robot.robotmap.LEFT_SOLENOID_DISENGAGE);
final Compressor compressor = new Compressor(0);


public void InitializeGearShifters()
{
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

public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


