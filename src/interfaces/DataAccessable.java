package interfaces;


import java.util.Vector;

import dataobjects.Contact;
import dataobjects.Offer;



public interface DataAccessable {
Vector<Contact> getContact();
boolean deleteContact(Contact argContact);
boolean addContact(Contact argContact);
boolean updateContact(Contact argContact);
boolean addOffer(Offer argOffer);
boolean updateOffer(Offer argOffer);
boolean deleteOffer(Offer argOffer);
Vector<Offer> getOffer();
}