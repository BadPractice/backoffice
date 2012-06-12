package mydefault;

import Browser.InBuchungBrowser;
import Browser.InRechnungBrowser;
import Browser.OutRechnungBrowser;
import interfaces.WindowControlable;

 

 public class Gui
 {
	 static private Gui myinstance = null;
	 MainGui mainGui = null;
	 WindowControlable currentWindow = null;

	 
	private Gui( ) 
	{
		//myContactBrowser = new ContactBrowser();
		mainGui = new MainGui();
	}
	public boolean openContacts(){
		if (currentWindow != null)
			currentWindow.close();
		currentWindow = new ContactBrowser();
		return true;
	}
	
	public boolean openOffers(){
		if (currentWindow != null)
			currentWindow.close();
		currentWindow = new OfferBrowser();
		return true;
	}
	
	public boolean openInRechnung(){
		if (currentWindow != null)
			currentWindow.close();
		currentWindow = new InRechnungBrowser();
		return true;
	}
	
	static public Gui getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Gui();
	 return myinstance;
	}
	public boolean openOutRechnung() {
		if (currentWindow != null)
			currentWindow.close();
		currentWindow = new OutRechnungBrowser();
		return true;
	}
	public boolean openInBuchung() {
		if (currentWindow != null)
			currentWindow.close();
		currentWindow = new InBuchungBrowser();
		return true;
		
	}
 }