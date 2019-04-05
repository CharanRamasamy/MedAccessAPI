package com.MedAccess.Logger;

import org.apache.log4j.Logger;

public class FileLogger extends AbstractLogger
{
	
	final static Logger logger = Logger.getLogger(FileLogger.class);
	
	public FileLogger(int level)
	{
	      this.level = level;
	}

	@Override
	protected void write(String message) 
	{
		logger.debug(message);
		
	}

}
