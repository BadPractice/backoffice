import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

import dataobjects.Contact;

class ContactBrowserDialog extends JDialog 
    { 
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		DialogComponents components = null;
		Contact contact = null;
     public ContactBrowserDialog(Contact argContact) 
         { 
    	 contact=argContact;
         JPanel panel = new JPanel(new GridLayout(0,2));
         setContentPane(panel); 
         components = new DialogComponents();
         components.bindFrom(contact);
         //adding fields to panel
         panel.add(components.getLabelName());
         panel.add(components.getName());
         panel.add(components.getLabelNName());
         panel.add(components.getNName());
         panel.add(components.getLabelPhone());
         panel.add(components.getPhone());
         panel.add(components.getLabelDate());
         panel.add(components.getDate());
         panel.add(components.getButtonOk());
         panel.add(components.getLabelError());
          
         // Use invokeLater AFTER the dialog is shown 

         setModal(true);
         listen();
         pack();
         setVisible( true );          
     } 
     private void endDialog()
     {
    	 this.dispose();
     }
     private void listen(){
 		components.getButtonOk().addActionListener(new ActionListener() {	
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				if(components.bindTo(contact))
 				{
 					if(contact.getId()==null)
 						Businesslogic.getInstance().addContact(contact);
 					else
 						Businesslogic.getInstance().updateContact(contact);
 					endDialog();
 				}
 					
 			}
 						
 		});
 		
 	}
}