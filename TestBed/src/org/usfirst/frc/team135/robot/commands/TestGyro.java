package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.subsystems.DriveTrain;
import org.usfirst.frc.team135.robot.utility.*;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestGyro extends Command {

	PIDController straightController;
	AngleOut angleOut;
	
    public TestGyro() {
    	requires(Robot.drivetrain);
    	
    	angleOut = new AngleOut();
    	straightController = new PIDController(.01, 0.0, 0.0, Robot.gyro.getPIDInput(), angleOut); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	straightController.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.ArcadeDrive(.5, angleOut.output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
