package models;

public class ErrorHandler {
	static private ErrorHandler myinstance= null;
	String error =null;
	private ErrorHandler(){}
	static public ErrorHandler getInstance(){
		if ( myinstance == null )
			myinstance = new ErrorHandler();
		return myinstance;
	}
	public void setError(String argError){
		error=argError;
	}
	public String getError(){
		if(error==null) return "Unbekannter Fehler";
		return error;
	}
	public void clearError(){
		error=null;
	}
	
	public boolean isValid(){
		if(error==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
