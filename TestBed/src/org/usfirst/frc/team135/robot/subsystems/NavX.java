package org.usfirst.frc.team135.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.I2C.Port;


public class NavX extends Subsystem implements PIDOutput {
	private static NavX instance;
	
	private AHRS ahrs;
    
	//Pitch yaw and roll: http://www.machinedesign.com/sites/machinedesign.com/files/pry-promo.gif
	
	public NavX()
	{
		ahrs = new AHRS(SerialPort.Port.kUSB2);
	}
	
	public static NavX getInstance()
	{
		if (instance == null)
		{
			instance = new NavX();
		}
		
		return instance;
	}
	

    public void initDefaultCommand()
    {
        ahrs.reset();
        ahrs.resetDisplacement();
    }

    public float getYaw()
    {
    	return ahrs.getYaw(); //getAngle() is a wrapper for getYaw()
    }
    
    public float getPitch()
    {
    	return ahrs.getPitch();
    }
    
    public float getRoll()
    {
    	return ahrs.getRoll();
    }
    
   
    public float getVelX()
    {
    	return ahrs.getVelocityX();
    }
    
    public float getVelY()
    {
    	return ahrs.getVelocityY();
    }
    
    public float getVelZ()
    {
    	return ahrs.getVelocityX();
    }
    
    public float getAcclX()
    {
    	return ahrs.getWorldLinearAccelX();
    }
    
    public float getAcclY()
    {
    	return ahrs.getWorldLinearAccelY();
    }
    
    public float getAcclZ()
    {
    	return ahrs.getWorldLinearAccelZ();
    }
    
    public float getDispX()
    {
    	return ahrs.getDisplacementX();
    }
    
    public float getDispY()
    {
    	return ahrs.getDisplacementY();
    }
    
    public float getDispZ()
    {
    	return ahrs.getDisplacementZ();
    }
    
    

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}

