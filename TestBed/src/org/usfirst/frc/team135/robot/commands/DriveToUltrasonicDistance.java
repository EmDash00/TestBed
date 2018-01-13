package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.*;
import org.usfirst.frc.team135.robot.subsystems.UltrasonicSensor;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToUltrasonicDistance extends Command {

    public DriveToUltrasonicDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sonar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (Robot.sonar.GetSonarValue() > 30 )
    	{
    		Robot.drivetrain.TankDrive(.5, -.5);
    	}
    	while (Robot.sonar.GetSonarValue() >=30 && Robot.sonar.GetSonarValue()< 20 )
    	{
    		Robot.drivetrain.TankDrive(.25, -.25);
    	}
    	while (Robot.sonar.GetSonarValue() <= 20 )
    	{
    		Robot.drivetrain.TankDrive(0,0);
    	}
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
