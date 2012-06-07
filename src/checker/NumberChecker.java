package checker;

import interfaces.Checkable;
import models.ErrorHandler;

public class NumberChecker implements Checkable<String> {

	@Override
	public boolean check(String arg) {
		if(arg==null) return false;
		if(arg=="") return false;
		if(arg.matches("[-]?[0-9]+")) return true;
		ErrorHandler.getInstance().setError("Dieses Feld darf nur zahlen von 0 bis 9 enthalten");
		return false;
	}
}
