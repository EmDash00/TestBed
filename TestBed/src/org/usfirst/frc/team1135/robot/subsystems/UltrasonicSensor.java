package org.usfirst.frc.team1135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Ultrasonic;

/**
 *
 */
public class UltrasonicSensor extends Subsystem {
	static final int SONAR_TRIGGER_PORT = 2;
	static final int SONAR_ECHO_PORT = 3;
	double distance = 0;
	private Ultrasonic sonar = new Ultrasonic(SONAR_TRIGGER_PORT,SONAR_ECHO_PORT);	
	
	private static UltrasonicSensor instance;
	
	public UltrasonicSensor()
	{
		sonar.setAutomaticMode(true);
	}
	
	public static UltrasonicSensor getInstance()
	{
		if (instance == null)
		{
			instance = new UltrasonicSensor();
		}
		
		return instance;
	}
	
	
	public double GetSonarValue() //is the distance in inches
	{
		return sonar.getRangeInches(); //Function that gets the inches range from the sonar
	}
	
	
	
	
    public void initDefaultCommand() {
        
    }
}

