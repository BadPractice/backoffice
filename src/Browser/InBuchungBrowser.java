package Browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import TableModels.BuchungTableModel;
import browserDialog.InBuchungBrowserDialog;
import dataobjects.Buchung;
import models.Browser;
import models.Businesslogic;

public class InBuchungBrowser extends Browser<Buchung> {

	BuchungTableModel model;
	 public InBuchungBrowser( ) 
		{
				model=new BuchungTableModel();
				mytable = new JTable(model);
				super.initLayout(model);
				frame.setTitle("InBuchungBrowser");
				//plugging components together
				mytable.setVisible(true);
			    frame.setVisible(true);	
			    frame.pack();
			   listen();
		}
		private void setData(){
			model.clearText();
			model.addText(Businesslogic.getInstance().getInBuchung());
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

					Businesslogic.getInstance().deleteInBuchung(model.getRow(mytable.getSelectedRow()));
					setData();
				}
			});
			
			
			buttonEdit.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					 new InBuchungBrowserDialog(model.getRow(mytable.getSelectedRow()));
					setData();
				}
							
			});
			
			buttonAdd.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					new InBuchungBrowserDialog(new Buchung());
				}
							
			});
			
		}
}
