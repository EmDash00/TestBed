package org.usfirst.frc.team135.robot.subsystems;
import org.usfirst.frc.team135.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.CANifier;
/**
 *
 */
public class Canifier extends Subsystem implements RobotMap {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	static private Canifier instance;
    static CANifier can;
	
	public static Canifier getInstance()
	{
		if (instance == null)
		{
			instance = new Canifier();
		}
		return instance;
	}
	
	private Canifier()
	{
		can = new CANifier(CANIFIER_ID);
		can.clearStickyFaults(20);	
	}
	
	public double GetVoltage()
	{
		double value = can.getBusVoltage();
		System.out.print("CANIFIER VOLTAGE = "+ value);
		return value;
	}
	
	public void SetPWM(int pwm_channel, double value)
	{
		can.setPWMOutput(pwm_channel, value); //value = duty cycle (0-1)
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

