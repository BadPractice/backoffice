package mydefault;


import interfaces.Tableable;
import interfaces.WindowControlable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import dataobjects.Contact;

import models.Browser;
import models.Businesslogic;
import models.ContactTableModel;
import models.OfferTableModel;
import models.SimpleModel;

 public class ContactBrowser extends Browser<Contact> implements ActionListener, WindowControlable
 {
	 
	 ContactTableModel model;
	 ContactBrowser( ) 
	{
			model=new ContactTableModel();
			mytable = new JTable(model);
			super.initLayout(model);
			frame.setTitle("ContactBrowser");
			//plugging components together
			mytable.setVisible(true);
		    frame.setVisible(true);	
		    frame.pack();
		   listen();
	}
	 
	private void setData(){
		model.clearText();
		model.addText(Businesslogic.getInstance().getContact());
	}
	
	private void listen(){
		buttonSearch.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//xxx= new ContactBrowser();
				setData();
			}
						
		});
		
		buttonDelete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {

				Businesslogic.getInstance().deleteContact(model.getRow(mytable.getSelectedRow()));
				setData();
			}
		});
		
		
		buttonEdit.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				 new ContactBrowserDialog(model.getRow(mytable.getSelectedRow()));
				setData();
			}
						
		});
		
		buttonAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new ContactBrowserDialog(new Contact());
			}
						
		});
		
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean close() {
		frame.dispose();
		return false;
	}
 }