package checker;

import interfaces.Checkable;
import models.ErrorHandler ;
public class NameChecker implements Checkable<String>
{
	public boolean check(String arg){
		if(arg==null) return false;
		if(arg=="") return false;
		if(arg.matches("[A-Z][a-z]*")) return true;
		ErrorHandler.getInstance().setError("ungültiger Name!");
		return false;
	}
}
