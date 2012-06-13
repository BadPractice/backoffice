package checker;

import mydefault.ErrorHandler;
import interfaces.Checkable;

public class FloatChecker implements Checkable<String> {

	@Override
	public boolean check(String arg) {
	if(arg!=null) 
	if(arg!="") 
	if(arg.matches("[0]([\\.][0-9]+)?")) return true;
	ErrorHandler.getInstance().setError("No valid Float value");
		return false;
	}
}
