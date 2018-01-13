package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.*;
import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.RobotMap; 

//import java.awt.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.TimedRobot;

import org.usfirst.frc.team135.robot.commands.AutoLeftStationAutoLine;
/**
 *
 */
public class AutoDriveStraight extends Command {


	public AutoDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sonar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		//set motors equal to .5 speed
    	//set timer value (How does this become generalized if the value differs for each path?) 
    	if (AutoOptions == AUTO_LEFT_STATION_AUTO_LINE) {
    		
    		while (Robot.sonar.GetSonarValue() > 30 ) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); //Does this get changed to MecanumDrive? 
    		}
    		while (Robot.sonar.GetSonarValue() >=30 && Robot.sonar.GetSonarValue()< 20 )
    		{
    			Robot.drivetrain.MecanumDrive(.25, -.25);
    		}
    		while (Robot.sonar.GetSonarValue() <= 20 )
    		{
    			Robot.drivetrain.MecanumDrive(0,0);
    		}
    	}
    	
    	else if (AutoOptions == AUTO_LEFT_STATION_LEFT_SWITCH_PLATE)
		{
			while (Robot.sonar.GetSonarValue() > 30 ) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); //Does this get changed to MecanumDrive? 
    		}
    		while (Robot.sonar.GetSonarValue() >=30 && Robot.sonar.GetSonarValue()< 20 )
    		{
    			Robot.drivetrain.MecanumDrive(.25, -.25);
    		}
    		while (Robot.sonar.GetSonarValue() <= 20 )
    		{
    			Robot.drivetrain.MecanumDrive(0,0);
    		}
		}
		
    	else if (AutoOptions == AUTO_LEFT_STATION_RIGHT_SWITCH_PLATE)
		{
			while (Robot.sonar.GetSonarValue() > 30 ) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.MecanumDrive(.5, -.5); //Does this get changed to MecanumDrive? 
    		}
    		while (Robot.sonar.GetSonarValue() >=30 && Robot.sonar.GetSonarValue()< 20 )
    		{
    			Robot.drivetrain.MecanumDrive(.25, -.25);
    		}
    		while (Robot.sonar.GetSonarValue() <= 20 )
    		{
    			Robot.drivetrain.MecanumDrive(0,0);
    		}
		}
		
		else 
		{
			Robot.drivetrain.MecanumDrive(0,0);
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
