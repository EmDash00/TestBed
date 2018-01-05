package org.usfirst.frc.team135.robot.wrappers;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class PIDTalonSRX implements PIDSource {

	private PIDSourceType m_pidSource = PIDSourceType.kDisplacement;
	
	private TalonSRX talon;
	private int  sensorIdx;
	
	public PIDTalonSRX(TalonSRX talon, int sensorIdx, PIDSourceType sourceType) {
		this.talon = talon;
		this.sensorIdx = sensorIdx;
		m_pidSource = sourceType;
		
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		m_pidSource = pidSource;
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return m_pidSource;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return talon.getSelectedSensorPosition(sensorIdx);
	}
	
	
	

}
