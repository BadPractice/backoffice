package checker;

import interfaces.Checkable;
import models.ErrorHandler ;
public class NameChecker implements Checkable<String>
{
	public boolean check(String arg){
		if(arg!=null) 
		if(arg!="") 
		if(arg.matches("[A-Z][a-z]*")) return true;
		System.out.println("NameChecker: Name ungültig");
		ErrorHandler.getInstance().setError("ungültiger Name!");
		System.out.println(ErrorHandler.getInstance().isValid());
		return false;
	}
}
