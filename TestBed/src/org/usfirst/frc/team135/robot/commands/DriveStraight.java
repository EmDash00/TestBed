package org.usfirst.frc.team135.robot.commands;

import java.util.Optional;

import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team135.robot.wrappers.*;
import org.usfirst.frc.team135.robot.wrappers.DistanceConfig.Device;

/**
 *
 */


public class DriveStraight extends Command {

	private DistanceOut distanceOut;
	private AngleOut angleOut;
	
	private PIDController distanceController, angleController;
	
	public DriveStraight(Optional<Double> angle, Optional<DistanceConfig> config, Optional<Double> timeout)
	{
		requires(Robot.drivetrain);
		requires(Robot.gyro);
		
		angleOut = new AngleOut();
		distanceOut = new DistanceOut();
		
		angleController = new PIDController(0.01f, 0.0f, 0.0f, Robot.gyro.getPIDInput(), angleOut);
	
		
		if (config.isPresent())
		{
			
			if (config.get().selectedDevice == Device.Lidar)
			{
				requires(Robot.lidar);
			}
			else if (config.get().selectedDevice == Device.UltrasonicSensor)
			{
				requires(Robot.sonar);
			}
			else if (config.get().selectedDevice == Device.Encoder)
			{
				//No "requires" necessary because encoders are included with Robot.drivetrain
				
				distanceController = new PIDController(0.0f, 0.0f, 0.0f, 
		    			Robot.drivetrain.getEncoderSource(DriveTrain.LEFT_ENCODER, PIDSourceType.kDisplacement),
		    			distanceOut);
			}
			
	    	distanceController.setSetpoint(config.get().setPoint);
	    	
	    	
		}
		
		angleController.setSetpoint(angle.orElse(0.0));
		
		if (timeout.isPresent())
		{
			setTimeout(timeout.get());
		}
		
		
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	angleController.enable();
    	if (distanceController != null)
    	{
    		distanceController.enable();
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.drivetrain.ArcadeDrive(distanceOut.output, angleOut.output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	angleController.disable();
    	if (distanceController != null)
    	{
    		distanceController.disable();
    	}
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
