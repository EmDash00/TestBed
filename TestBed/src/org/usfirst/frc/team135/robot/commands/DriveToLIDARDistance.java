package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToLIDARDistance extends Command {
	
	double desiredDistance;
	double decelerateDistance = 5;

    public DriveToLIDARDistance(double distance) {
    	requires(Robot.can);
    	requires(Robot.drivetrain);
    	
    	this.desiredDistance = distance;
    }	

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.TankDrive(0, 0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while (Robot.can.ReadLidar() > desiredDistance && Robot.can.ReadLidar() >= decelerateDistance)
    	{
    		Robot.drivetrain.TankDrive(.5, .5);
    	} 
    	while (Robot.can.ReadLidar()< decelerateDistance) 
    	{
    		Robot.drivetrain.TankDrive(.25, .25);
    	}
    	
    	Robot.drivetrain.TankDrive(0, 0);
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
