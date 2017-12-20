package org.usfirst.frc.team1135.robot.wrappers;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class pid_RobotDrive extends RobotDrive implements PIDOutput
{

	public pid_RobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
			SpeedController frontRightMotor, SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		this.drive(.3, output);
	}
}
