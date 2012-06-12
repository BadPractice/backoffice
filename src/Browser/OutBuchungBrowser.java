package Browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import models.Browser;
import models.Businesslogic;
import TableModels.BuchungTableModel;

import dataobjects.Buchung;

public class OutBuchungBrowser extends Browser<Buchung> {
	BuchungTableModel model;
	 public OutBuchungBrowser( ) 
		{
				model=new BuchungTableModel();
				mytable = new JTable(model);
				super.initLayout(model);
				frame.setTitle("BuchungBrowser");
				//pluggOutg components together
				mytable.setVisible(true);
			    frame.setVisible(true);	
			    frame.pack();
			   listen();
		}
		private void setData(){
			model.clearText();
			model.addText(Businesslogic.getInstance().getOutBuchung());
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

				//	Businesslogic.getInstance().deleteOutBuchung(model.getRow(mytable.getSelectedRow()));
					setData();
				}
			});
			
			
			buttonEdit.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
				//	 new OutBuchungBrowserDialog(model.getRow(mytable.getSelectedRow()));
					setData();
				}
							
			});
			
			buttonAdd.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
				//	new OutBuchungBrowserDialog(new Buchung());
				}
							
			});
			
		}
}
