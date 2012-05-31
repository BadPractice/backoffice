

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import dataobjects.Contact;

import models.SimpleModel;

 public class ContactBrowser implements ActionListener
 {
	 JTable mytable = null;
	 JButton  buttonSearch= null, buttonEdit= null, buttonDelete=null, buttonAdd=null;
	 JFrame frame = null;
	 SimpleModel model = null; 
	 JPanel panel= null;
	 ContactBrowser xxx = null;
	 
	 ContactBrowser( ) 
	{
		panel=new JPanel(new BorderLayout());
		frame = new JFrame("Kontakte");
		frame.getContentPane().add(panel);
		buttonSearch= new JButton("Search");
		buttonDelete= new JButton("Delete");
		buttonEdit= new JButton("Edit");
		buttonAdd= new JButton("Add");
		model=new SimpleModel();
		mytable = new JTable(model);
		JPanel buttonPanel = new JPanel(new GridLayout(0,1));
		JPanel tablePanel = new JPanel(new BorderLayout());
		//plugging components together
		buttonPanel.add(buttonSearch);
		buttonPanel.add(buttonEdit );
		buttonPanel.add(buttonDelete);
		buttonPanel.add(buttonAdd);
		tablePanel.add(mytable,BorderLayout.WEST);
		panel.add(buttonPanel, BorderLayout.EAST);
		panel.add(tablePanel,BorderLayout.CENTER);
		mytable.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				xxx= new ContactBrowser();
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
 }