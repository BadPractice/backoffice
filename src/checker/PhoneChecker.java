package checker;

import interfaces.Checkable;

import javax.swing.JTextField;

import mydefault.ErrorHandler;


public class PhoneChecker implements Checkable<String> {

	@Override
	public boolean check(String arg) {
		if(arg!=null) 
		if(arg!="") 
		if(arg.matches("[0-9]+")) return true;
		ErrorHandler.getInstance().setError("ungültige Telephonnummer!");
		return false;
	}

}
