package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.*;

/**
 *
 */
public class NavX extends Subsystem {
	
	
	private static NavX instance;
	
	private static AHRS navx;
	private float nullPrecessionAngle;
	
	private NavX()
	{
		navx = new AHRS(Port.kUSB1);
	}
	
	public static NavX getInstance()
	{
		if (instance == null)
		{
			instance = new NavX();
		}
		return instance;
	}
	
	public float navxAngle()
	{
		nullPrecessionAngle = navx.getFusedHeading();
		return nullPrecessionAngle;
	}
	
    public void initDefaultCommand() 
    {
     
    }
    
    public void periodic()
    {
    	System.out.println(navxAngle());
    }
}

