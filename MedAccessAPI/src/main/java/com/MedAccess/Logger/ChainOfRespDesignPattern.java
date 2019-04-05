package com.MedAccess.Logger;

public class ChainOfRespDesignPattern 
{
	
	
	public static AbstractLogger setChainOfLoggers()
	{

	      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
	      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	      errorLogger.setNextLogger(fileLogger);
	      fileLogger.setNextLogger(consoleLogger);

	      return errorLogger;	
	      
	}
	

}
