package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team135.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team135.robot.commands.DriveIntakeWheels;


/**
 *
 */
public class Intake extends Subsystem implements RobotMap{
	
	private WPI_VictorSPX leftIntakeMotor, rightIntakeMotor;
	

	private static Intake instance;
	
	public static Intake getInstance()
	{
		if (instance == null)
		{
			instance = new Intake();
		}
		return instance;
	}
	
	private Intake()
	{
		leftIntakeMotor = new WPI_VictorSPX(LEFT_INTAKE_VICTOR_ID);
		rightIntakeMotor = new WPI_VictorSPX(RIGHT_INTAKE_VICTOR_ID);
		InitializeIntakeMotors();
	}
	
	public void InitializeIntakeMotors()
	{
		leftIntakeMotor.setInverted(false);
		rightIntakeMotor.setInverted(true);
		
		leftIntakeMotor.setSafetyEnabled(false);
		rightIntakeMotor.setSafetyEnabled(false);
	}

	
	public void DriveIntakeMotors(double power)
	{
		leftIntakeMotor.set(power);
		rightIntakeMotor.set(power);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveIntakeWheels());
    }
}

