package models;
import java.util.Vector;

import javax.xml.crypto.Data;

import logger.Logger;
import mydefault.Database;


import dataobjects.Buchung;
import dataobjects.Contact;
import dataobjects.Offer;
import dataobjects.Rechnung;



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
		Logger.getInstance().push("Contacts requested");
		Vector<Contact> mydata = Database.getInstance().getContact();
		if(mydata == null)
		{
			System.out.println("Database error");
			return null;//Database error
		}
		return mydata;//auf return wert  ändern
	}
	
	public Vector<Offer> getOffer() {
		Logger.getInstance().push("Offer requested");
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
		Logger.getInstance().push("Offer delete requested");
		return Database.getInstance().deleteOffer(argOffer);
	}
	

	public boolean deleteContact(Contact argContact){
		Logger.getInstance().push("Contact delete requested");
		return Database.getInstance().deleteContact(argContact);
	}
	public boolean addContact(Contact argContact){
		Logger.getInstance().push("Contact add requested");
		return Database.getInstance().addContact(argContact);
	}
	
	public boolean updateContact(Contact argContact){
		Logger.getInstance().push("Contact update requested");
		return Database.getInstance().updateContact(argContact);
	}
	public boolean addOffer(Offer dataObject) {
		Logger.getInstance().push("Offer add requested");
		return Database.getInstance().addOffer(dataObject);
		
	}
	public boolean updateOffer(Offer dataObject) {
		Logger.getInstance().push("Offer update requested");
		return Database.getInstance().updateOffer(dataObject);
		
	}
	public boolean deleteInRechnung(Rechnung row) {
		return Database.getInstance().deleteInRechnung(row);
		// TODO Auto-generated method stub
		
	}
	public Vector<Rechnung> getInRechnung() {
		return Database.getInstance().getInRechnung();
	}
	public boolean updateInRechnung(Rechnung dataObject) {
		return Database.getInstance().updateInRechnung(dataObject);
	}
	public boolean addInRechnung(Rechnung dataObject) {
		return Database.getInstance().addInRechnung(dataObject);
		
	}
	public Vector<Rechnung> getOutRechnung() {
		return Database.getInstance().getOutRechnung();
	}
	public boolean deleteOutRechnung(Rechnung row) {
		return Database.getInstance().deleteOutRechnung(row);
	}
	public boolean addOutRechnung(Rechnung dataObject) {

		return Database.getInstance().addOutRechnung(dataObject);
	}	
	public boolean updateOutRechnung(Rechnung dataObject) {

		return Database.getInstance().updateOutRechnung(dataObject);
	}
	public boolean addInBuchung(Buchung dataObject) {
		// TODO Auto-generated method stub
		return Database.getInstance().addInBuchung(dataObject);
		
	}
	public boolean deleteInBuchung(Buchung row) {
		return Database.getInstance().deleteInBuchung(row);
		
	}
	public boolean updateInBuchung(Buchung dataObject) {
		return Database.getInstance().updateInBuchung(dataObject);
		
	}
	public Vector<Buchung> getInBuchung() {
		// TODO Auto-generated method stub
		return Database.getInstance().getInBuchung();
	}
	public Vector<Buchung> getOutBuchung() {
		return Database.getInstance().getOutBuchung();
	}
/*	public boolean deleteOutBuchung(Buchung row) {		
	}	*/
}



