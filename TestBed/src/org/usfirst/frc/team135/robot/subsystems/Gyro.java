package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {
	private ADXRS450_Gyro gyro;
	
    private static Gyro instance;
	
    public static Gyro getInstance()
    {
    	if (instance == null)
    	{
    		instance = new Gyro();
    	}
    	return instance;
    }
    
    
	public Gyro()
	{
		gyro = new ADXRS450_Gyro(); //Gyro is connected to the onboard SPI on line 0
		gyro.reset();
		gyro.calibrate();
	}
	
	public ADXRS450_Gyro getPIDInput()
	{
		return gyro;	
	}
	
	public double getAngle()
	{
		return gyro.getAngle();
	}
	
	public double getRate()
	{
		return gyro.getRate();
	}
	
	public void resetGyro()
	{
		gyro.reset();
	}
	
	
	protected void initDefaultCommand() {
        
    }
}

