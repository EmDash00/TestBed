package org.usfirst.frc.team135.robot.wrappers;

import edu.wpi.first.wpilibj.PIDOutput;

public class DistanceOut implements PIDOutput
{
	public double output;

	
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		this.output = output;
		
	}
	

}
