package org.usfirst.frc.team135.robot.utility;

public class DistanceConfig 
{
	
	public enum Device
	{
		UltrasonicSensor,
		Lidar,
		Camera,
		Encoder
	}
	
	public Device selectedDevice;
	public double setPoint;
	
	public DistanceConfig(Device selectedDevice, double setPoint)
	{
		this.selectedDevice = selectedDevice;
		this.setPoint = setPoint;
	}
	
	

}
