package logger;

import interfaces.Loggable;

public class LoggerOff implements Loggable{

	@Override
	public void push(String text) {
		 System.out.println(text);
	}

}
