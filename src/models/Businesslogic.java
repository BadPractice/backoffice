package models;
import java.util.Vector;

import mydefault.Database;


import dataobjects.Contact;
import dataobjects.Offer;



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
	
	public Vector<Offer> getOffer() {
		Vector<Offer> mydata = Database.getInstance().getOffer();
		//System.out.println(mydata.get(0).getSum());
		if(mydata == null)
		{
			System.out.println("Database error");
			return null;//Database error
		}
		return mydata;//auf return wert  ändern
	}
	
	public boolean deleteOffer(Offer argOffer){
		return Database.getInstance().deleteOffer(argOffer);
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
	public boolean addOffer(Offer dataObject) {
		return Database.getInstance().addOffer(dataObject);
		
	}
	public boolean updateOffer(Offer dataObject) {
		return Database.getInstance().updateOffer(dataObject);
		
	}	
}
