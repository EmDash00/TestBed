package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team135.robot.RobotMap;
import org.usfirst.frc.team135.robot.commands.DriveJ;
import org.usfirst.frc.team135.robot.wrappers.PIDTalonSRX;
import org.usfirst.frc.team135.robot.wrappers.PIDTalonSRX;

import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;


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
	
	
	private static WPI_TalonSRX[] drivetrainMotors;
	
	private static final double ENCODER2ROTATIONS = (1 / 4096.0);
	
	
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
		
		drivetrainMotors = new WPI_TalonSRX[NUMBER_DRIVETRAIN_MOTORS];

		drivetrainMotors[FRONT_LEFT] = new WPI_TalonSRX(FRONT_LEFT_TALON_ID);
		drivetrainMotors[REAR_LEFT] = new WPI_TalonSRX(REAR_LEFT_TALON_ID);
		drivetrainMotors[FRONT_RIGHT] = new WPI_TalonSRX(FRONT_RIGHT_TALON_ID);
		drivetrainMotors[REAR_RIGHT] = new WPI_TalonSRX(REAR_RIGHT_TALON_ID);
		
		InitializeDriveTrainMotors();
		resetEncoderValue(LEFT_ENCODER);
		resetEncoderValue(RIGHT_ENCODER);

	}

	public void InitializeDriveTrainMotors() {

		chassis = new DifferentialDrive(
				new SpeedControllerGroup(drivetrainMotors[FRONT_LEFT],
						drivetrainMotors[REAR_LEFT]),
				new SpeedControllerGroup(drivetrainMotors[FRONT_RIGHT],
						drivetrainMotors[REAR_RIGHT]));

		drivetrainMotors[FRONT_LEFT].setInverted(LEFT_SIDE_INVERTED);
		drivetrainMotors[FRONT_RIGHT].setInverted(RIGHT_SIDE_INVERTED);
		drivetrainMotors[REAR_LEFT].setInverted(LEFT_SIDE_INVERTED);
		drivetrainMotors[REAR_RIGHT].setInverted(RIGHT_SIDE_INVERTED);

		chassis.setSafetyEnabled(false);

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

	/*	for (int i = LEFT_ENCODER; i <= RIGHT_ENCODER; i += 2) {
			drivetrainMotors[i].configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 1, 10);
			drivetrainMotors[i].setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 10, 10);
			drivetrainMotors[i].setSensorPhase(ENCODER_REVERSED[i]);
		} */
//this is bad
		
		drivetrainMotors[LEFT_ENCODER].configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 1, 10);
		drivetrainMotors[LEFT_ENCODER].setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 10, 10);
		drivetrainMotors[LEFT_ENCODER].setSensorPhase(ENCODER_REVERSED[RIGHT_ENCODER]);
		
		drivetrainMotors[RIGHT_ENCODER].configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 1, 10);
		drivetrainMotors[RIGHT_ENCODER].setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature, 10, 10);
		drivetrainMotors[RIGHT_ENCODER].setSensorPhase(ENCODER_REVERSED[LEFT_ENCODER]);
		
	}
	
	// (ticks/4096 ticks)*(4 *2*math.pi in/1 rev) = Distance (inches)
	
	public double getEncoderValue(int side) {
		return (((double) drivetrainMotors[side].getSelectedSensorPosition(DEFAULT_SENSOR_INDEX)));
	}

	public double getRightEncoderDist(){
		double RIGHT_ENCODER_REVS = (getEncoderValue(RIGHT_ENCODER) / 4096);
		double RIGHT_ENCODER_DISTANCE = (RIGHT_ENCODER_REVS * (4*2*Math.PI));
		return RIGHT_ENCODER_DISTANCE;
		
	}
	
	public double getLeftEncoderDist(){
		double LEFT_ENCODER_REVS = (getEncoderValue(LEFT_ENCODER) / 4096);
		double LEFT_ENCODER_DISTANCE = (LEFT_ENCODER_REVS * (4*2*Math.PI));
		return LEFT_ENCODER_DISTANCE;
		
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

	public void MecanumDrive(double d, double e) {
		// TODO Auto-generated method stub
		
	}


}

