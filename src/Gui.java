
 public class Gui
 {
	 
	 ContactBrowser myContactBrowser = null;
	 ContactBrowser myProjectBrowser = null;
	 ContactBrowser getcontactbrowser(){
		 if (myContactBrowser != null) return myContactBrowser;
		 return myContactBrowser = new ContactBrowser();
	 }
	 static private Gui myinstance = null;
	 
	private Gui( ) 
	{
		myContactBrowser = new ContactBrowser();
		//myProjectBrowser = new ContactBrowser();
	
	}
	
	static public Gui getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Gui();
	 return myinstance;
	}
 }