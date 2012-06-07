package checker;

import interfaces.Checkable;
import models.ErrorHandler;

public class FreeTextChecker  implements Checkable<String> {
	public boolean check(String arg){
		if(arg==null) return false;
		if(arg=="") return false;
		if(arg.matches("/(\\%27)|(\\')|(\\-\\-)|(\\%23)|(#)/ix")== false) return true;
		ErrorHandler.getInstance().setError("ungültiger Name!");
		return false;
	}
}
