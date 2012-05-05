
public class ErrorHandler {
	static private ErrorHandler myinstance= null;
	String error =null;
	private ErrorHandler(){
		error="Unbekannter Fehler";
	}
	static public ErrorHandler getInstance(){
		if ( myinstance == null )
			myinstance = new ErrorHandler();
		return myinstance;
	}
	public void setError(String argError){
		error=argError;
	}
	public String getError(){
		return error;
	}
}
