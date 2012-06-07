package mydefault;
import interfaces.ContactInformable;


public class InputChecker {
	
	public boolean checkAll(ContactInformable argContact){
		if(false == checkName(argContact.getName()))return false;
		if(false == checkName(argContact.getNName()))return false;
		if(false == checkDate(argContact.getDate()))return false;
		if(false == checkPhone(argContact.getPhone()))return false;
		//additional Attributs could get checked here
		System.out.println("test sucessful");
		return true;
	}
	public boolean checkPhone(String argPhone){
		if(argPhone==null) return false;
		if(argPhone=="") return false;
		if(argPhone.matches("[0-9]*")) return true;
		ErrorHandler.getInstance().setError("ungültige Telephonnummer!");
		return false;
	}
	
	
	public boolean checkName(String argName){
		if(argName==null) return false;
		if(argName=="") return false;
		if(argName.matches("[A-Z][a-z]*")) return true;
		ErrorHandler.getInstance().setError("ungültiger Name!");
		return false;
	}
	public boolean checkDate(String argDate){
		if(argDate==null) return false;
		if(argDate=="") return false;
		if(argDate.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d")) return true;
		ErrorHandler.getInstance().setError("ungültiges Datum!");
		return false;
	}
}
