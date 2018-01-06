package org.usfirst.frc.team135.robot.commands;

import java.util.Optional;

import org.usfirst.frc.team135.robot.wrappers.AngleOut;
import org.usfirst.frc.team135.robot.wrappers.DistanceOut;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class DriveStraight_Tem extends Command {

	protected DistanceOut distanceOut;
	protected AngleOut angleOut;

	
	
    public DriveStraight_Tem(Optional<Double> distance, double angle, boolean increase) 
    {
    	
    }
    
    

    
}
