package mydefault;

public class ErrorHandler {
	static private ErrorHandler myinstance= null;
	String error =null;
	Boolean isValid;
	private ErrorHandler(){
		error=new String("Unbekannter Fehler");
		isValid=new Boolean(true);
	}
	static public ErrorHandler getInstance(){
		if ( myinstance == null )
			myinstance = new ErrorHandler();
		return myinstance;
	}
	public void clearError(){
		isValid =true;
		error=null;
	}
	public void setError(String argError){
		error=argError;
		isValid=false;
	}
	public String getError(){
		return error;
	}
	public Boolean isValid(){
		return isValid;
	}
	public void resetError(){
		error = "Unbekannter Fehler";
		isValid=true;
	}
}
