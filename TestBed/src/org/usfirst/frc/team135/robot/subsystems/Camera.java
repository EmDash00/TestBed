package org.usfirst.frc.team135.robot.subsystems;

import java.io.*;
import java.net.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	private static final int ERR_TIMEOUT = -1, ERR_IOEXCEPTION = -2, VALID = 0;
	private static final double VAL_TIMEOUT = 1;
	private static final String ACKNOWLEDGE = "ACKNOWLEDGED REQUEST.";
	
	private Timer timer = new Timer();
	
	private static final String[] FUNCTIONS =
		{
			"White Filter",
			"Median Blur",
			"Guassian Blur",
			"Morphological Open",
			"Morphological Close",
			"Canny"
		};
	private static final String[] CONFIG_SETTINGS =
		{
			"Threshold`",
			"Median Blur Kernel Size`",
			"Morphological Operation Kernel`"
		};
	
	private ServerSocket server;
	private Socket client;
		    
	private PrintWriter out;
	private BufferedReader in;
	
	private static final int PORT = 25565;
		
	private static Camera instance;
	
	public boolean ValidState = true;
	
	public Camera()
	{	
		if (initSockets() != VALID)
		{		
			ValidState = false;
			return;
		}
		
		if (initConfiguration() != VALID)
		{
			ValidState = false;
			return;
		}
		timer.stop();
		timer.reset();	
	}
	
	private int initSockets()
	{
		try 
		{

			server = new ServerSocket(PORT);
			client = server.accept();
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader( new InputStreamReader(client.getInputStream()));	
			timer.start();
				
			while (true)
			{	
				if (timer.get() > 1)
				{
					System.out.println("Unable to accept the client in time. Constructor failed. Quitting...");
					timer.stop();
					return ERR_TIMEOUT;
				}
				timer.stop();
				return VALID;
			}
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			timer.stop();
			return ERR_IOEXCEPTION;
		}
		
	}

	private int initConfiguration()
	{
		for (String setting : CONFIG_SETTINGS)
		{
			out.println(setting);
			timer.start();
			
			try
			{
				while(true)
				{
					if (in.ready())
					{
						if (in.readLine() == ACKNOWLEDGE)
						{
							timer.stop();
							timer.reset();
							break;
						}
					}
					
					if (timer.get() > VAL_TIMEOUT)
					{
						timer.stop();
						timer.reset();
						System.out.println("Error 2: Timed out. Setting could not be configured. "
								+ "Using default value instead. Skipping to next setting...");
						break;
					}
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
				timer.stop();
				timer.reset();
				System.out.println("Error 1: IO Exception. Did the client close the connection on their end?");
				return ERR_IOEXCEPTION;
			}		
		}
		
		return VALID;
		
	}
	
	public static Camera getInstance()
	{
		if (instance == null)
		{
			instance = new Camera();
		}
		
		return instance;
	}
	
	public int issueCommand(String command)
	{
		out.println(command);
		
		try
		{
			while(true)
			{
				if (in.ready())
				{
					if (in.readLine() == ACKNOWLEDGE)
					{
						timer.stop();
						timer.reset();
						return VALID;
					}
				}
				
				if (timer.get() > VAL_TIMEOUT)
				{
					timer.stop();
					timer.reset();
					System.out.println("Error 2: Timed out. Request not recieved.");
					return ERR_TIMEOUT;
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			timer.stop();
			timer.reset();
			
			System.out.println("Error 1: IO Exception. Did the client close the connection on their end?");
			return ERR_IOEXCEPTION;
		}
		
		
	}
	
	public double requestAngle()
	{
		out.println("Requesting angle`");
		
		try
		{
			while(true)
			{
				if (in.ready())
				{
					return Double.parseDouble(in.readLine());
				}
				
				if (timer.get() > VAL_TIMEOUT)
				{
					timer.stop();
					timer.reset();
					System.out.println("Error 2: Timed out. Unable to get angle.");
					return ERR_TIMEOUT - 1000;
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			timer.stop();
			timer.reset();
			
			System.out.println("Error 1: IO Exception. Did the client close the connection on their end?");
			return ERR_IOEXCEPTION - 1000;
		}
	}
	
	public double requestDistance()
	{
		out.println("Requesting distance`");
		
		try
		{
			while(true)
			{
				if (in.ready())
				{
					return Double.parseDouble(in.readLine());
				}
				
				if (timer.get() > VAL_TIMEOUT)
				{
					timer.stop();
					timer.reset();
					System.out.println("Error 2: Timed out. Unable to get angle.");
					return ERR_TIMEOUT;
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			timer.stop();
			timer.reset();
			
			System.out.println("Error 1: IO Exception. Did the client close the connection on their end?");
			return ERR_IOEXCEPTION;
		}
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

