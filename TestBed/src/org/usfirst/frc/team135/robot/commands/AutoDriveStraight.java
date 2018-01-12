package org.usfirst.frc.team135.robot.commands;

import java.awt.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveStraight extends Command {

    public AutoDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(something);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//set motors equal to .5 speed
    	//set timer value (How does this become generalized if the value differs for each path?) 
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
