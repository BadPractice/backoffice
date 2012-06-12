package interfaces;


import java.util.Vector;

import dataobjects.Buchung;
import dataobjects.Contact;
import dataobjects.Offer;
import dataobjects.Rechnung;



public interface DataAccessable {
Vector<Contact> getContact();
boolean deleteContact(Contact argContact);
boolean addContact(Contact argContact);
boolean updateContact(Contact argContact);
boolean addOffer(Offer argOffer);
boolean updateOffer(Offer argOffer);
boolean deleteOffer(Offer argOffer);
Vector<Offer> getOffer();
Vector<Rechnung> getInRechnung();
boolean deleteInRechnung(Rechnung row);
boolean addInRechnung(Rechnung argContact);
boolean updateInRechnung(Rechnung argContact);
Vector<Rechnung> getOutRechnung();
boolean deleteOutRechnung(Rechnung row);
boolean addOutRechnung(Rechnung argContact);
boolean updateOutRechnung(Rechnung argContact);
boolean addOutBuchung(Buchung argContact);
boolean deleteInBuchung(Buchung row);
boolean addInBuchung(Buchung argContact);
boolean updateOutBuchung(Buchung argContact);
boolean updateInBuchung(Buchung argContact);
Vector<Buchung> getInBuchung();
Vector<Buchung> getOutBuchung();
boolean deleteOutBuchung(Buchung row);
}