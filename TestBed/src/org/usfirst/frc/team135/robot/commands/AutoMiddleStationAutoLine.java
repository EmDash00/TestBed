package org.usfirst.frc.team135.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team135.robot.RobotMap;
import org.usfirst.frc.team135.robot.commands.AutoDriveStraight;

/**
 *
 */

//FORGET ABOUT THIS FOR A SEC...
public class AutoMiddleStationAutoLine extends CommandGroup {

    public AutoMiddleStationAutoLine() {
    	addSequential(new AutoDriveStraight(RobotMap.autoLineMid));
    	//addSequential(AutoTurnLeft());
    	//addSequential(AutoDriveStraight());
    	//addSequential(AutoTurnRight());s
    	//addSequential(AutoDriveStraight());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }

	
	}

