import java.util.Vector;

import models.Contact;


public class Businesslogic {
	 static private Businesslogic myinstance = null;
	 private Businesslogic(){		
		}
	static public Businesslogic getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Businesslogic();
	 return myinstance;
	}
	
	public Vector<Contact> getContact() {
		Vector<Contact> mydata = Database.getInstance().getContact();
		if(mydata == null)
		{
			System.out.println("Database error");
			return null;//Database error
		}
		return mydata;//auf return wert  ändern
	}

	public boolean deleteContact(Contact argContact){
		return Database.getInstance().deleteContact(argContact);
	}
	public boolean addContact(Contact argContact){
		return Database.getInstance().addContact(argContact);
	}
	
	public boolean updateContact(Contact argContact){
		return Database.getInstance().updateContact(argContact);
	}	
}
