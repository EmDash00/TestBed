package org.usfirst.frc.team135.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurnLeft extends Command {

    public AutoTurnLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(something)
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//angle = new angle;
    	// while (angle < 270)
    	//{
    	// set motors (-.5) and (.5) to spin;
    	//}
    	// while (angle >= 270)    	// {
    	// set motors equal to zero; 
    	//}
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