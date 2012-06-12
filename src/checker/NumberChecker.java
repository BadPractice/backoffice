package checker;

import interfaces.Checkable;
import models.ErrorHandler;

public class NumberChecker implements Checkable<String> {

	@Override
	public boolean check(String arg) {
		if(arg!=null)
		if(arg!="")
		if(arg.matches("[-]?[0-9]+")) return true ;
		ErrorHandler.getInstance().setError("Dieses Feld darf nur zahlen von 0 bis 9");
		return false;
	}
}
