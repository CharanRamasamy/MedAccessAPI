package com.MedAccess.Logger;

import org.apache.log4j.Logger;


public class ConsoleLogger extends AbstractLogger
{
	
	final static Logger logger = Logger.getLogger(ConsoleLogger.class);
	
	public ConsoleLogger(int level)
	{
	      this.level = level;
	}

	@Override
	protected void write(String message) 
	{
		
		logger.info(message);
		
	}

}
