package org.usfirst.frc.team135.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team135.robot.RobotMap;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.PWMChannel;

/**
 *
 */
public class CANifierSensors extends Subsystem implements RobotMap {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	static public CANifierSensors instance;
	static public CANifier canifier;
	
	CANifier.PWMChannel Lidar = CANifier.PWMChannel.PWMChannel0;
	
	double[][] dutyCycleAndPeriods = new double[][] {new double[] {0, 0}, new double[] {0, 0}, new double[] {0, 0}, new double[] {0, 0}};
	
	public CANifierSensors()
	{
		canifier = new CANifier(CANIFIER_ID);
	}
	
	public static CANifierSensors getInstance()
	{
		if (instance == null)
		{
			instance = new CANifierSensors();
		}
		return instance;
	}
	
	public double MeasurePulseWidth(CANifier.PWMChannel channel)
	{
		canifier.getPWMInput(Lidar, dutyCycleAndPeriods[0]);
		
		return dutyCycleAndPeriods[channel.value][0];
	}
	
	public double ReadLidar()
	{
		double reading = MeasurePulseWidth(Lidar)/10; 
		double distanceInches = (reading)*(conversions.CM2INCH);
		return distanceInches;
	}

    public void initDefaultCommand() {
    	
    }
}

