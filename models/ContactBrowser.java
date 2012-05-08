package models;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import dataobjects.Contact;


 public class ContactBrowser implements ActionListener
 {
	 JTable mytable = null;
	 JButton  buttonSearch= null, buttonEdit= null, buttonDelete=null, buttonAdd=null;
	 JFrame frame = null;
	 SimpleModel model = null; 
	 JPanel panel= null;
	 
	 ContactBrowser( ) 
	{
		 //inizialiseing several GUI components (buttons, tables, panels,usw.)
		 frame = new JFrame("Kontakte");
		panel=new JPanel(new BorderLayout());//this panel represents the entire window
		frame.getContentPane().add(panel);
		buttonSearch= new JButton("Search");
		buttonDelete= new JButton("Delete");
		buttonEdit= new JButton("Edit");
		buttonAdd= new JButton("Add");
		model=new SimpleModel();
		mytable = new JTable(model);
		JPanel buttonPanel = new JPanel(new GridLayout(0,1));//this panel has the button
		JPanel tablePanel = new JPanel(new BorderLayout());
		//plugging buttons to button panel
		buttonPanel.add(buttonSearch);
		buttonPanel.add(buttonEdit );
		buttonPanel.add(buttonDelete);
		buttonPanel.add(buttonAdd);
		tablePanel.add(mytable,BorderLayout.WEST);//plugging table to table panel
		panel.add(buttonPanel, BorderLayout.EAST);//adding panel with buttons to main panel
		panel.add(tablePanel,BorderLayout.CENTER);//adding panel with tables to main panel
		mytable.setVisible(true);//not even sure if i need that...
		//starting GUI
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);	
	    frame.pack();
	   listen();
	}
	 
	 //this method is fetching the data from the database
	 //and saving in the table model called model
	private void setData(){
		model.clearText();
		model.addText(Businesslogic.getInstance().getContact());
	}
	
	private void listen(){
		
		//when search button is pressed...
		buttonSearch.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				setData();
			}
		});
		
		//when delete button is pressed...
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
 }