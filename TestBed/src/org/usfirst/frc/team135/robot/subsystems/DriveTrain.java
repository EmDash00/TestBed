package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team135.robot.RobotMap;
import org.usfirst.frc.team135.robot.commands.DriveJ;
import org.usfirst.frc.team135.robot.wrappers.PIDTalonSRX;

import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 *
 */
public class DriveTrain extends Subsystem implements RobotMap {
	
	private static final int NUMBER_DRIVETRAIN_MOTORS = 4;
	private static final int FRONT_LEFT = 0;
	private static final int REAR_LEFT = 1;
	private static final int FRONT_RIGHT = 2;
	private static final int REAR_RIGHT = 3;

	private static final int DEFAULT_SENSOR_INDEX = 1;
	public static final int LEFT_ENCODER = FRONT_LEFT;
	public static final int RIGHT_ENCODER = FRONT_RIGHT;
	
	//-1 is reversed. 1 is not reversed.
	private static final boolean[] ENCODER_REVERSED = {true, true};
	
	
	private static TalonSRX[] drivetrainMotors;
	
	private static final int ENCODER2ROTATIONS = (1 / 4096);
	
	
	private DifferentialDrive chassis;

	private static DriveTrain instance;


	public void initDefaultCommand() {
		setDefaultCommand(new DriveJ());
	}

	public static DriveTrain getInstance() {
		if (instance == null) {
			instance = new DriveTrain();
		}
		return instance;
	}

	private DriveTrain() {
		// InitializeDriveTrainMotors();
		drivetrainMotors = new TalonSRX[NUMBER_DRIVETRAIN_MOTORS];

		drivetrainMotors[FRONT_LEFT] = new TalonSRX(FRONT_LEFT_TALON_ID);
		drivetrainMotors[REAR_LEFT] = new TalonSRX(REAR_LEFT_TALON_ID);
		drivetrainMotors[FRONT_RIGHT] = new TalonSRX(FRONT_RIGHT_TALON_ID);
		drivetrainMotors[REAR_RIGHT] = new TalonSRX(REAR_RIGHT_TALON_ID);
		resetEncoderValue(LEFT_ENCODER);
		resetEncoderValue(RIGHT_ENCODER);

	}

	public void InitializeDriveTrainMotors() {

		chassis = new DifferentialDrive(
				new SpeedControllerGroup(drivetrainMotors[FRONT_LEFT].getWPILIB_SpeedController(),
						drivetrainMotors[REAR_LEFT].getWPILIB_SpeedController()),
				new SpeedControllerGroup(drivetrainMotors[FRONT_RIGHT].getWPILIB_SpeedController(),
						drivetrainMotors[REAR_RIGHT].getWPILIB_SpeedController()));

		drivetrainMotors[FRONT_LEFT].setInverted(LEFT_SIDE_INVERTED);
		drivetrainMotors[FRONT_RIGHT].setInverted(RIGHT_SIDE_INVERTED);
		drivetrainMotors[REAR_LEFT].setInverted(LEFT_SIDE_INVERTED);
		drivetrainMotors[REAR_RIGHT].setInverted(RIGHT_SIDE_INVERTED);

	}

	public void InitailzeEncoders() {
		/*
		 * drivetrainMotors[RIGHT_ENCODER].configEncoderCodesPerRev(ENCODER_COUNT);
		 * drivetrainMotors[LEFT_ENCODER].configEncoderCodesPerRev(ENCODER_COUNT);
		 * 
		 * drivetrainMotors[RIGHT_ENCODER].reverseFeedbackDevice(LEFT_ENCODER_REVERSED);
		 * drivetrainMotors[LEFT_ENCODER].reverseSensor(RIGHT_ENCODER_REVERSED);
		 * 
		 * drivetrainMotors[LEFT_ENCODER].setFeedbackDevice(FeedbackDevice.QuadEncoder);
		 * drivetrainMotors[RIGHT_ENCODER].setFeedbackDevice(FeedbackDevice.QuadEncoder) ;
		 * 
		 * drivetrainMotors[LEFT_ENCODER].setStatusFrameRateMs(StatusFrameRate.QuadEncoder, 10);
		 * drivetrainMotors[RIGHT_ENCODER].setStatusFrameRateMs(StatusFrameRate.QuadEncoder, 10);
		 */

		for (int i = LEFT_ENCODER; i <= RIGHT_ENCODER; i += 2) {
			drivetrainMotors[i].configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 1, 10);
			drivetrainMotors[i].setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 10, 10);
			drivetrainMotors[i].setSensorPhase(ENCODER_REVERSED[i]);
		}

	}

	public double getEncoderValue(int side) {
		return (((double) drivetrainMotors[side].getSelectedSensorPosition(DEFAULT_SENSOR_INDEX) * ENCODER2ROTATIONS));
	}

	public void resetEncoderValue(int side) {
		drivetrainMotors[side].setSelectedSensorPosition(DEFAULT_SENSOR_INDEX, 0, 10);
	}

	public void TankDrive(double left, double right) {
		chassis.tankDrive(left, right);
	}
	
	public void ArcadeDrive(double power, double angle)
	{
		chassis.arcadeDrive(power, angle);
	}
	
	public PIDTalonSRX getEncoderSource(int encoder, PIDSourceType type)
	{
		return new PIDTalonSRX(drivetrainMotors[encoder], DEFAULT_SENSOR_INDEX, type);
	}


}

