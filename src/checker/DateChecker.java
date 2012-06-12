package checker;

import mydefault.ErrorHandler;
import interfaces.Checkable;

public class DateChecker implements Checkable<String> {

	@Override
	public boolean check(String arg) {
		if(arg!=null) 
		if(arg!="") 
		if(arg.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")) return true;
		ErrorHandler.getInstance().setError("ungültiges Datum!");
		return false;
	}

}
