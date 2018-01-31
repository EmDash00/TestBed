package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Ultrasonic;

/**
 *
 */
public class UltrasonicSensor extends Subsystem {
	static final int BACK_SONAR_TRIGGER_PORT = 2;
	static final int BACK_SONAR_ECHO_PORT = 3;
	
	static final int FRONT_SONAR_TRIGGER_PORT = 0;
	static final int FRONT_SONAR_ECHO_PORT = 1;
	
	double distance = 0;
	private Ultrasonic backSonar = new Ultrasonic(BACK_SONAR_TRIGGER_PORT,BACK_SONAR_ECHO_PORT);	
	
	private static UltrasonicSensor instance;
	
	public UltrasonicSensor()
	{
		backSonar.setAutomaticMode(true);
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
		double value = sonar.getRangeInches(); //Function that gets the inches range from the sonar
		System.out.println("Distance = "+ value);
		return value;
	}
	
    public void initDefaultCommand() {
        
    }
}

