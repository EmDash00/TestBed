package org.usfirst.frc.team135.robot.commands;

import org.usfirst.frc.team135.robot.OI;
import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class DriveJ extends Command {

	
    public DriveJ() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.InitializeDriveTrainMotors();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//System.out.println(OI.getInstance().GetLeftJoystickY() + ", " + OI.getInstance().GetRightJoystickY());
    	Robot.drivetrain.TankDrive(-OI.getInstance().GetLeftJoystickY(), OI.getInstance().GetRightJoystickY());
    	System.out.println(Robot.drivetrain.getEncoderValue(DriveTrain.LEFT_ENCODER) + ", " + Robot.drivetrain.getEncoderValue(DriveTrain.RIGHT_ENCODER));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.TankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
