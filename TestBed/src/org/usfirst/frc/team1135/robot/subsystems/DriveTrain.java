package org.usfirst.frc.team1135.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1135.robot.commands.DriveJ;
import org.usfirst.frc.team1135.robot.Robot;
import org.usfirst.frc.team1135.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;

import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	final static int NUMBER_DRIVETRAIN_MOTORS = 4;
	
	static final int FRONT_LEFT = 0;
	static final int REAR_LEFT = 1;
	static final int FRONT_RIGHT = 2;
	static final int REAR_RIGHT = 3;

	static CANTalon[] drivetrainMotors = new CANTalon[NUMBER_DRIVETRAIN_MOTORS];
	
public RobotDrive chassis;
 
 public ADXRS450_Gyro gyro;
 

public void InitializeDriveTrainMotors()
{
	drivetrainMotors[FRONT_LEFT] = new CANTalon(Robot.robotmap.FRONT_LEFT_TALON_ID);
	drivetrainMotors[REAR_LEFT] = new CANTalon(Robot.robotmap.REAR_LEFT_TALON_ID);
	drivetrainMotors[FRONT_RIGHT] = new CANTalon(Robot.robotmap.FRONT_RIGHT_TALON_ID);
	drivetrainMotors[FRONT_LEFT] = new CANTalon(Robot.robotmap.FRONT_LEFT_TALON_ID);

	chassis = new RobotDrive(drivetrainMotors[FRONT_LEFT], drivetrainMotors[REAR_LEFT],  drivetrainMotors[FRONT_RIGHT],	drivetrainMotors[REAR_RIGHT]);
	chassis.setSafetyEnabled(false);
	
	drivetrainMotors[FRONT_LEFT].setInverted(Robot.robotmap.LEFT_SIDE_INVERTED);
	drivetrainMotors[FRONT_RIGHT].setInverted(Robot.robotmap.RIGHT_SIDE_INVERTED);
	drivetrainMotors[REAR_LEFT].setInverted(Robot.robotmap.LEFT_SIDE_INVERTED);
	drivetrainMotors[REAR_RIGHT].setInverted(Robot.robotmap.RIGHT_SIDE_INVERTED);
}

public void TankDrive(double leftpower, double rightpower)
{
	chassis.tankDrive(leftpower, rightpower);
}



public void initDefaultCommand() 
{

    setDefaultCommand(new DriveJ());
    }
}

