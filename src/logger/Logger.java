package logger;

import interfaces.Loggable;
import models.Config;


public class Logger {
		 static private Loggable myinstance = null;

		 private Logger(){
			 
		 }
		 
	static public Loggable getInstance()
	{
	 if ( myinstance == null )
	 {
		 if (Config.getInstance().isLogging())
		 {
			 myinstance = new LoggerOn();
		 }
		 else
		 {
			 myinstance = new LoggerOff();
		 }
	 }
	 return myinstance;
	}
}
