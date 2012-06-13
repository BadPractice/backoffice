package checker;

import mydefault.ErrorHandler;
import interfaces.Checkable;

public class FreeTextChecker  implements Checkable<String> {
	public boolean check(String arg){
		if(arg!=null) 
		if(arg!="") 
		if(arg.matches("/(\\%27)|(\\')|(\\-\\-)|(\\%23)|(#)/ix")== false) return true;
		ErrorHandler.getInstance().setError("ungültiger Name!");
		return false;
	}
}
