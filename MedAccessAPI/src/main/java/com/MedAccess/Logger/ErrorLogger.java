package com.MedAccess.Logger;

import org.apache.log4j.Logger;

public class ErrorLogger extends AbstractLogger
{
	final static Logger logger = Logger.getLogger(ErrorLogger.class);
	
	public ErrorLogger(int level)
	{
	      this.level = level;
	}

	@Override
	protected void write(String message) 
	{
		logger.error(message);
		
	}

}
