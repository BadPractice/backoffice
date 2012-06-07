package mydefault;

import interfaces.WindowControlable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import models.Browser;
import models.Businesslogic;
import models.OfferTableModel;
import models.SimpleModel;
import dataobjects.Contact;
import dataobjects.Offer;

public class OfferBrowser extends Browser<Offer> implements ActionListener, WindowControlable {
	OfferTableModel model;
	 
	 public OfferBrowser( ) 
	{
		 model=new OfferTableModel();
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
		model.addText(Businesslogic.getInstance().getOffer());
	}
	
	private void listen(){
		buttonSearch.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setData();
			}
						
		});
		
		buttonDelete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {

				Businesslogic.getInstance().deleteOffer(model.getRow(mytable.getSelectedRow()));
				setData();
			}
		});
		
		
		buttonEdit.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				 new OfferBrowserDialog(model.getRow(mytable.getSelectedRow()));
				setData();
			}
						
		});
		
		buttonAdd.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new OfferBrowserDialog(new Offer());
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
