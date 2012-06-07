package checker;

import interfaces.Checkable;

public class FloatChecker implements Checkable<String> {

	@Override
	public boolean check(String arg) {
	if(arg==null) return false;
	if(arg=="") return false;
	if(arg.matches("[-+]?[0-9]*\\.?[0-9]+")) return true;
		// TODO Auto-generated method stub
		return false;
	}
}
