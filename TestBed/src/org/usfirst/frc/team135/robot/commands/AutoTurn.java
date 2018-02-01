package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class AutoTurn extends CommandGroup {

	private int left, right, encoder;
	private Timer timer;
	
    public AutoTurn(int x, int y, int z) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	left = x;
    	right = y;
    	encoder = z;
    	
    	
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		
    		timer.start();
    		while (Math.abs(Robot.drivetrain.getRightEncoderDist()) < encoder && Math.abs(Robot.drivetrain.getLeftEncoderDist()) < encoder 
    				&& timer.get() < 3 && DriverStation.getInstance().isAutonomous()) 
    		{
    			Robot.drivetrain.TankDrive((.5*left), (.5*right)); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Math.abs(Robot.drivetrain.getRightEncoderDist()) > encoder || Math.abs(Robot.drivetrain.getLeftEncoderDist()) > encoder 
    				&& timer.get() < 3 && DriverStation.getInstance().isAutonomous())
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
