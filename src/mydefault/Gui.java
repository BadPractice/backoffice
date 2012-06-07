package mydefault;

import interfaces.WindowControlable;



 public class Gui
 {
	 static private Gui myinstance = null;
	 MainGui mainGui = null;
	 WindowControlable currentWindow = null;
	// ContactBrowser myProjectBrowser = null;
	/* ContactBrowser getcontactbrowser(){
		 if (myContactBrowser != null) return myContactBrowser;
		 return myContactBrowser = new ContactBrowser();
	 }
	 */
	 
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
	
	static public Gui getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Gui();
	 return myinstance;
	}
 }