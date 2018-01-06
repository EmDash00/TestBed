package org.usfirst.frc.team135.robot.wrappers;

import java.util.Optional;

import edu.wpi.first.wpilibj.PIDOutput;

public class DistanceOut implements PIDOutput
{
	public double output = .4; //Default power for a drivetrain

	
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		this.output = output;
		
	}
	

}
