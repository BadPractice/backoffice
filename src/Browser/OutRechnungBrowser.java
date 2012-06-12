package Browser;


	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JTable;

	import browserDialog.InRechnungBrowserDialog;
import browserDialog.OutRechnungBrowserDialog;

	import TableModels.RechnungTableModel;

	import dataobjects.Contact;
	import dataobjects.Rechnung;
	import models.Browser;
	import models.Businesslogic;
import models.ContactTableModel;

	public class OutRechnungBrowser extends Browser<Rechnung> {
		RechnungTableModel model;
		 public OutRechnungBrowser( ) 
			{
					model=new RechnungTableModel();
					mytable = new JTable(model);
					super.initLayout(model);
					frame.setTitle("RechnungBrowser");
					//pluggOutg components together
					mytable.setVisible(true);
				    frame.setVisible(true);	
				    frame.pack();
				   listen();
			}
			private void setData(){
				model.clearText();
				model.addText(Businesslogic.getInstance().getOutRechnung());
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

						Businesslogic.getInstance().deleteOutRechnung(model.getRow(mytable.getSelectedRow()));
						setData();
					}
				});
				
				
				buttonEdit.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						 new OutRechnungBrowserDialog(model.getRow(mytable.getSelectedRow()));
						setData();
					}
								
				});
				
				buttonAdd.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						new OutRechnungBrowserDialog(new Rechnung());
					}
								
				});
				
			}
	}


