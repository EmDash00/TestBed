package org.usfirst.frc.team1135.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1135.robot.commands.DriveJ;
//import org.usfirst.frc.team1135.robot.Robot;
import org.usfirst.frc.team1135.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;

import com.ctre.CANTalon;


/**
 *
 */
public class DriveTrain extends Subsystem implements RobotMap {
	
	private static int NUMBER_DRIVETRAIN_MOTORS = 4;
	private static final int FRONT_LEFT = 0;
	private static final int REAR_LEFT = 1;
	private static final int FRONT_RIGHT = 2;
	private static final int REAR_RIGHT = 3;

	private static CANTalon[] drivetrainMotors;
	
public RobotDrive chassis;
 
public ADXRS450_Gyro gyro;

private static DriveTrain instance;


public void initDefaultCommand() 
{
    setDefaultCommand(new DriveJ());
    }

public static DriveTrain getInstance()
{
	if (instance == null)
	{
		instance = new DriveTrain();
	}
	return instance;
}

private DriveTrain()
{
	//InitializeDriveTrainMotors();
	drivetrainMotors = new CANTalon[NUMBER_DRIVETRAIN_MOTORS];

	drivetrainMotors[FRONT_LEFT] = new CANTalon(FRONT_LEFT_TALON_ID);
	drivetrainMotors[REAR_LEFT] = new CANTalon(REAR_LEFT_TALON_ID);
	drivetrainMotors[FRONT_RIGHT] = new CANTalon(FRONT_RIGHT_TALON_ID);
	drivetrainMotors[REAR_RIGHT] = new CANTalon(REAR_RIGHT_TALON_ID);
	
	InitializeDriveTrainMotors();

}

 
public void InitializeDriveTrainMotors()
{

	chassis = new RobotDrive(drivetrainMotors[FRONT_LEFT], drivetrainMotors[REAR_LEFT],  drivetrainMotors[FRONT_RIGHT],	drivetrainMotors[REAR_RIGHT]);
	
	drivetrainMotors[FRONT_LEFT].setInverted(LEFT_SIDE_INVERTED);
	drivetrainMotors[FRONT_RIGHT].setInverted(RIGHT_SIDE_INVERTED);
	drivetrainMotors[REAR_LEFT].setInverted(LEFT_SIDE_INVERTED);
	drivetrainMotors[REAR_RIGHT].setInverted(RIGHT_SIDE_INVERTED);
	
	drivetrainMotors[FRONT_LEFT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	drivetrainMotors[FRONT_RIGHT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	drivetrainMotors[REAR_LEFT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	drivetrainMotors[REAR_RIGHT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);

}


public void TankDrive(double left, double right)
{
	chassis.tankDrive(left, right);
}
}

