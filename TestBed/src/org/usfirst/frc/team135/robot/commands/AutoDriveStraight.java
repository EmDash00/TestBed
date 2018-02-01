package org.usfirst.frc.team135.robot.commands;

//import org.usfirst.frc.team135.robot.*;
import org.usfirst.frc.team135.robot.Robot;
import org.usfirst.frc.team135.robot.RobotMap; 
//import org.usfirst.frc.team135.robot.subsystems.DriveTrain;

//import java.awt.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

//import org.usfirst.frc.team135.robot.commands.AutoLeftStationAutoLine;
/**
 *4096 rpm
 */
public class AutoDriveStraight extends Command {
	
	private Timer timer;
	private int distance;

	public AutoDriveStraight(int x) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sonar);
    	distance = x;
    	timer = new Timer();
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		//set motors equal to .5 speed
    	//set timer value (How does this become generalized if the value differs for each path?) 
    	if (distance == RobotMap.autoLine) {
    		
    		timer.start();
    		while (Robot.sonar.GetSonarValue() <RobotMap.autoLine && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) 
    		{
    			Robot.drivetrain.TankDrive(-.5, .5); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoLine && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.TankDrive(0,0);
    		}
    	}
    	
    	else if (distance == RobotMap.autoLineMid) {
    		
    		timer.start();
    		while (Robot.sonar.GetSonarValue() <RobotMap.autoLineMid && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.TankDrive(-.5, .5); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoLineMid && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.TankDrive(0,0);
    		}
    	}
    	
   	else if (distance == RobotMap.autoSwitch) {
    		
    		timer.start();
    		while (Robot.sonar.GetSonarValue() <RobotMap.autoSwitch && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.TankDrive(-.5, .5); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoSwitch && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.TankDrive(0,0);
    		}
    	}
    	
   		else if (distance == RobotMap.autoSwitchSide) {
		
   			timer.start();
   			while (Robot.sonar.GetSonarValue() <RobotMap.autoSwitchSide && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
   			{
   				Robot.drivetrain.TankDrive(-.5, .5); 
   			}
   			timer.stop();
   			timer.reset();
   			timer.start();
   			while (Robot.sonar.GetSonarValue() >= RobotMap.autoSwitchSide && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
   			{
   				Robot.drivetrain.TankDrive(0,0);
   			}
   		}
	
   		else if (distance == RobotMap.autoScale) {
    		
    		timer.start();
    		while (Robot.sonar.GetSonarValue() <RobotMap.autoScale && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.TankDrive(-.5, .5); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoScale && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.TankDrive(0,0);
    		}
   		}
    	
   		else if (distance == RobotMap.autoScaleSide) {
    		
    		timer.start();
    		while (Robot.sonar.GetSonarValue() <RobotMap.autoScaleSide && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.TankDrive(-.5, .5); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.sonar.GetSonarValue() >= RobotMap.autoScaleSide && timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.TankDrive(0,0);
    		}
		}
    	
    	else if (distance == RobotMap.autoLineEnc) {
    		
    		timer.start();
    		while (Robot.drivetrain.getRightEncoderDist()<RobotMap.autoLineEnc && Robot.drivetrain.getLeftEncoderDist()<RobotMap.autoLineEnc && timer.get() < 3 && DriverStation.getInstance().isAutonomous()) //change value when we know that we need for each path
    		{
    			Robot.drivetrain.TankDrive(-.5, .5); 
    		}
    		timer.stop();
    		timer.reset();
    		timer.start();
    		while (Robot.drivetrain.getRightEncoderDist() >= RobotMap.autoLineEnc || Robot.drivetrain.getRightEncoderDist() >= RobotMap.autoLineEnc&& timer.get() < 3 && DriverStation.getInstance().isAutonomous())
    		{
    			Robot.drivetrain.TankDrive(0,0);
    		}
    	}

		else 
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
