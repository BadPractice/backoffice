package Browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import browserDialog.InRechnungBrowserDialog;

import TableModels.RechnungTableModel;

import dataobjects.Contact;
import dataobjects.Rechnung;
import models.Browser;
import models.Businesslogic;
import models.ContactTableModel;

public class InRechnungBrowser extends Browser<Rechnung> {
	RechnungTableModel model;
	 public InRechnungBrowser( ) 
		{
				model=new RechnungTableModel();
				mytable = new JTable(model);
				super.initLayout(model);
				frame.setTitle("RechnungBrowser");
				//plugging components together
				mytable.setVisible(true);
			    frame.setVisible(true);	
			    frame.pack();
			   listen();
		}
		private void setData(){
			model.clearText();
			model.addText(Businesslogic.getInstance().getInRechnung());
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

					Businesslogic.getInstance().deleteInRechnung(model.getRow(mytable.getSelectedRow()));
					setData();
				}
			});
			
			
			buttonEdit.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					 new InRechnungBrowserDialog(model.getRow(mytable.getSelectedRow()));
					setData();
				}
							
			});
			
			buttonAdd.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					new InRechnungBrowserDialog(new Rechnung());
				}
							
			});
			
		}
}
