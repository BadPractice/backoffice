package models;

import java.sql.Date;
import java.util.Vector;

import dataobjects.Buchung;
import dataobjects.Contact;
import dataobjects.Offer;
import dataobjects.Rechnung;
import interfaces.DataAccessable;

public class DummyDatabase implements DataAccessable {

	@Override
	public boolean addContact(Contact argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addInBuchung(Buchung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addInRechnung(Rechnung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addOffer(Offer argOffer) {
		return true;
	}

	@Override
	public boolean addOutBuchung(Buchung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addOutRechnung(Rechnung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteContact(Contact argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteInBuchung(Buchung row) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteInRechnung(Rechnung row) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteOffer(Offer argOffer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteOutBuchung(Buchung row) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteOutRechnung(Rechnung row) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Vector<Contact> getContact() {
		Vector<Contact> vec = new Vector<Contact>();
		Contact mycontact = new Contact();
		mycontact.setId(1);
		mycontact.setName("Dummy");
		mycontact.setNName("Dummy");
		mycontact.setPhone("12345");
		mycontact.setDate(new Date(0));
		vec.add(mycontact);
		return vec;
	}

	@Override
	public Vector<Buchung> getInBuchung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Rechnung> getInRechnung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Offer> getOffer() {
		Vector<Offer> vec = new Vector<Offer>();
		Offer myOffer = new Offer();
		myOffer.setChance(new Float(1));
		myOffer.setId(0);
		myOffer.setSum(0);
		myOffer.setDate(new Date(0));
		myOffer.setDuration("never");
		myOffer.setProjectId(0);
		myOffer.setCustomerId(0);
		vec.add(myOffer);
		return vec;
	}

	@Override
	public Vector<Buchung> getOutBuchung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Rechnung> getOutRechnung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateContact(Contact argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInBuchung(Buchung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInRechnung(Rechnung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateOffer(Offer argOffer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateOutBuchung(Buchung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateOutRechnung(Rechnung argContact) {
		// TODO Auto-generated method stub
		return true;
	}

}
