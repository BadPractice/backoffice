package checker;

import mydefault.ErrorHandler;
import interfaces.Checkable;
public class NameChecker implements Checkable<String>
{
	public boolean check(String arg){
		if(arg!=null) 
		if(arg!="") 
		if(arg.matches("[A-Z][a-z]*")) return true;
		ErrorHandler.getInstance().setError("ungültiger Name!");
		return false;
	}
}
