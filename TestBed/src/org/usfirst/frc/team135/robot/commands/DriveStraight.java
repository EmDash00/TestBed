package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team135.robot.wrappers.*;

/**
 *
 */


public class DriveStraight extends Command {

	private float distance, angle;
	
	private DistanceOut distanceOut;
	private AngleOut angleOut;
	
	private PIDController distanceController, angleController;
	
    public DriveStraight(float angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.gyro);
    	distanceOut = new DistanceOut();
    	angleOut = new AngleOut();
    	this.angle = angle;
    	
    	angleController = new PIDController(0.0f, 0.0f, 0.0f, Robot.gyro.getPIDInput(), angleOut);
    	angleController.setSetpoint(angle);
    }
    
    public DriveStraight(float distance, float angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.gyro);
    	distanceOut = new DistanceOut();
    	angleOut = new AngleOut();
    	this.distance = distance;
    	this.angle = angle;
    	
    	angleController = new PIDController(0.0f, 0.0f, 0.0f, Robot.gyro.getPIDInput(), angleOut);
    	distanceController = new PIDController(0.0f, 0.0f, 0.0f, 
    			Robot.drivetrain.getEncoderSource(DriveTrain.LEFT_ENCODER, PIDSourceType.kDisplacement),
    			distanceOut);
    	
    	distanceController.setSetpoint(distance);
    	angleController.setSetpoint(angle);
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
