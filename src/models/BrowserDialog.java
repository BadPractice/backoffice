package models;

import interfaces.Dialogable;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import mydefault.ContactDialogComponents;
import dataobjects.Contact;

public abstract class BrowserDialog<t> extends JDialog  {

	private static final long serialVersionUID = 1L;
	//protected Dialogable<t> components = null;
	protected JPanel panel;
	protected t dataObject = null;
 protected void doBasics(t argDataObject, Dialogable<t> myComponents) 
     { 
	 dataObject=argDataObject;
      panel = new JPanel(new GridLayout(0,2));
     setContentPane(panel); 
     myComponents.bindFrom(dataObject);
     //adding fields to panel
     panel.add(myComponents.getButtonOk());
     panel.add(myComponents.getErrorLabel());
      
     // Use invokeLater AFTER the dialog is shown 

         
 } 
 protected void endDialog()
 {
	 this.dispose();
 }

	
}
