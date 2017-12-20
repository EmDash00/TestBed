package org.usfirst.frc.team135.robot.wrappers;

import com.ctre.phoenix.MotorControl.*;
import com.ctre.phoenix.MotorControl.CAN.*;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class pid_DifferentialDrive extends DifferentialDrive implements PIDOutput
{

	public static enum Mode
	{
		STRAIGHT,
		DISTANCE
	}
	
	private Mode setMode;
	
	public pid_DifferentialDrive(TalonSRX frontLeftMotor, TalonSRX rearLeftMotor,
			TalonSRX frontRightMotor, TalonSRX rearRightMotor, Mode mode) 
	{
		super(new SpeedControllerGroup(frontLeftMotor.getWPILIB_SpeedController(), rearLeftMotor.getWPILIB_SpeedController()), 
				new SpeedControllerGroup(frontRightMotor.getWPILIB_SpeedController(), rearRightMotor.getWPILIB_SpeedController()));
		
		setMode = mode;
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		if (setMode == Mode.STRAIGHT)
		{
			
		}
		else if (setMode == Mode.DISTANCE)
		{
			
		}
		
	}
	
	private void StraightPID(double output)
	{
		this.curvatureDrive(.3, output, false);
	}
	
	private void DistancePID(double output)
	{
		
	}
}
