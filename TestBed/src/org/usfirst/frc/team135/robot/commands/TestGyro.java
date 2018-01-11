package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.subsystems.DriveTrain;
import org.usfirst.frc.team135.robot.utility.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestGyro extends Command {

	private double power;
	PIDController straightController;
	AngleOut angleOut;
	
    public TestGyro(double power) {
    	requires(Robot.drivetrain);
    	
    	angleOut = new AngleOut();
    	straightController = new PIDController(.05, 0.001, 0.0, Robot.gyro.getPIDInput(), angleOut); 
    	
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	straightController.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Timer timer = new Timer();
    	timer.start();
    	while(timer.get() < 60)
    	{
    		System.out.println(Robot.gyro.getRate());
    		Timer.delay(.1);
    	}
    	//Robot.drivetrain.ArcadeDrive(power, angleOut.output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	straightController.disable();
    	Robot.drivetrain.ArcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
