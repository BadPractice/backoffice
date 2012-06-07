package mydefault;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

import models.BrowserDialog;
import models.Businesslogic;

import dataobjects.Contact;
import dataobjects.Offer;

class ContactBrowserDialog extends BrowserDialog<Contact>
    { 
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		ContactDialogComponents components = null;
     public ContactBrowserDialog(Contact argContact) 
         { 
         components = new ContactDialogComponents();
         super.doBasics(argContact, components);
         components.bindFrom(dataObject);
         //adding fields to panel
         panel.add(components.getLabelName());
         panel.add(components.getName());
         panel.add(components.getLabelNName());
         panel.add(components.getNName());
         panel.add(components.getLabelPhone());
         panel.add(components.getPhone());
         panel.add(components.getLabelDate());
         panel.add(components.getDate());
         // Use invokeLater AFTER the dialog is shown 

         setModal(true);
         listen();
         pack();
         setVisible( true );          
     } 
     private void listen(){
 		components.getButtonOk().addActionListener(new ActionListener() {	
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				if(components.bindTo(dataObject))
 				{
 					if(dataObject.getId()==null)
 						Businesslogic.getInstance().addContact(dataObject);
 					else
 						Businesslogic.getInstance().updateContact(dataObject);
 					endDialog();
 				}
 				return;
 					
 			}
 						
 		});
 		
 	}
}