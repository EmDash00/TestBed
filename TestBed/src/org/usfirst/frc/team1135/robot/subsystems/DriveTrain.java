package org.usfirst.frc.team1135.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1135.robot.commands.DriveJ;
import org.usfirst.frc.team1135.robot.wrappers.pid_RobotDrive;
//import org.usfirst.frc.team1135.robot.Robot;
import org.usfirst.frc.team1135.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.StatusFrameRate;


/**
 *
 */
public class DriveTrain extends Subsystem implements RobotMap {
	
	private static final int NUMBER_DRIVETRAIN_MOTORS = 4;
	private static final int FRONT_LEFT = 0;
	private static final int REAR_LEFT = 1;
	private static final int FRONT_RIGHT = 2;
	private static final int REAR_RIGHT = 3;

	public static final int LEFT_ENCODER = FRONT_LEFT;
	public static final int RIGHT_ENCODER = FRONT_RIGHT;
	
	private static final boolean LEFT_ENCODER_REVERSED = true;
	private static final boolean RIGHT_ENCODER_REVERSED = true;
	
	
	private static CANTalon[] drivetrainMotors;
	
	private static final int ENCODER_COUNT = 256;
	private static final int QUAD_COUNT = (ENCODER_COUNT * 4);
	
	
	public pid_RobotDrive chassis;
	public ADXRS450_Gyro gyro;
	
	public PIDController straightController;

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

	gyro = new ADXRS450_Gyro(); //Gyro is connected to the onboard SPI on line 0
	
	drivetrainMotors[FRONT_LEFT] = new CANTalon(FRONT_LEFT_TALON_ID);
	drivetrainMotors[REAR_LEFT] = new CANTalon(REAR_LEFT_TALON_ID);
	drivetrainMotors[FRONT_RIGHT] = new CANTalon(FRONT_RIGHT_TALON_ID);
	drivetrainMotors[REAR_RIGHT] = new CANTalon(REAR_RIGHT_TALON_ID);
	resetEncoderValue(LEFT_ENCODER);
	resetEncoderValue(RIGHT_ENCODER);
	
	

	
}

 
public void InitializeDriveTrainMotors()
{

	chassis = new pid_RobotDrive(drivetrainMotors[FRONT_LEFT], drivetrainMotors[REAR_LEFT],  drivetrainMotors[FRONT_RIGHT],	drivetrainMotors[REAR_RIGHT]);
	
	straightController = new PIDController(.1, 0, 0, gyro, chassis);
	straightController.setSetpoint(0);
	
	drivetrainMotors[FRONT_LEFT].setInverted(LEFT_SIDE_INVERTED);
	drivetrainMotors[FRONT_RIGHT].setInverted(RIGHT_SIDE_INVERTED);
	drivetrainMotors[REAR_LEFT].setInverted(LEFT_SIDE_INVERTED);
	drivetrainMotors[REAR_RIGHT].setInverted(RIGHT_SIDE_INVERTED);
	
	drivetrainMotors[FRONT_LEFT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	drivetrainMotors[FRONT_RIGHT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	drivetrainMotors[REAR_LEFT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	drivetrainMotors[REAR_RIGHT].changeControlMode(CANTalon.TalonControlMode.PercentVbus);

}

public void InitailzeEncoders()
{
	drivetrainMotors[RIGHT_ENCODER].configEncoderCodesPerRev(ENCODER_COUNT);
	drivetrainMotors[LEFT_ENCODER].configEncoderCodesPerRev(ENCODER_COUNT);
	
	drivetrainMotors[RIGHT_ENCODER].reverseSensor(LEFT_ENCODER_REVERSED);
	drivetrainMotors[LEFT_ENCODER].reverseSensor(RIGHT_ENCODER_REVERSED);
	
	drivetrainMotors[LEFT_ENCODER].setFeedbackDevice(FeedbackDevice.QuadEncoder);
	drivetrainMotors[RIGHT_ENCODER].setFeedbackDevice(FeedbackDevice.QuadEncoder);
	
	drivetrainMotors[LEFT_ENCODER].setStatusFrameRateMs(StatusFrameRate.QuadEncoder, 10);
	drivetrainMotors[RIGHT_ENCODER].setStatusFrameRateMs(StatusFrameRate.QuadEncoder, 10);
}

public double getEncoderValue(int side)
{
	return drivetrainMotors[side].getEncPosition();
}

public void resetEncoderValue(int side)
{
	drivetrainMotors[side].setEncPosition(0);
}

public void DriveToDistance()
{
	
}

public void TankDrive(double left, double right)
{
	chassis.tankDrive(left, right);
}

}

