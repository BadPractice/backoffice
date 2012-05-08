package interfaces;


import java.util.Vector;

import dataobjects.Contact;



public interface DataAccessable {
Vector<Contact> getContact();
boolean deleteContact(Contact argContact);
boolean addContact(Contact argContact);
boolean updateContact(Contact argContact);
}