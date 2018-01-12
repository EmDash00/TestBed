package org.usfirst.frc.team135.robot.subsystems;

import org.usfirst.frc.team135.robot.RobotMap;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lidar extends Subsystem implements RobotMap
{
	private static Lidar instance;
	
	private I2C lidar;
	
	private static final int UPPER_ADDRESS = 0x0f;
	private static final int LOWER_ADDRESS = 0x10;
	
	public static Lidar getInstance()
	{
		if (instance == null)
		{
			instance = new Lidar();
		}
		
		return instance;
	}
	
	public Lidar()
	{
		lidar = new I2C(Port.kOnboard, 0x62); //0x62 is the default slave address for lidars
	}
	
	public float getDistance()
	{
		byte[] lowerByte = new byte[1];
		byte[] upperByte = new byte[1];
		
		getLowerByte(lowerByte);
		getUpperByte(upperByte);
		
		int lowerInt = (int)lowerByte[0];
		int upperInt = (int)upperByte[0];
		
		int rawValue = (upperInt << 8) + lowerInt;
		
		float convertedValue = rawValue * conversions.CM2INCH;
		System.out.print("LIDAR VALUE = " + convertedValue);
		return convertedValue;
	}
	
	private void getUpperByte(byte[] buf) 
	{
		
		lidar.read(UPPER_ADDRESS, 1, buf);
	}

	private void getLowerByte(byte[] buf) 
	{
		lidar.read(LOWER_ADDRESS, 1, buf);
	}
 

    public void initDefaultCommand() {
      
    	
    }
}

