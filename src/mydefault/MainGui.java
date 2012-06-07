package mydefault;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import models.SimpleModel;


public class MainGui implements ActionListener{
	JPanel panel= null;
	JFrame frame= null;
	JButton buttonContact= null, buttonOffer = null, buttonContract =null;
	MainGui(){
	panel=new JPanel(new GridLayout(0,1));
	
	frame = new JFrame("Main Window");
	frame.getContentPane().add(panel);
	buttonContact= new JButton("Contacts");
	buttonOffer= new JButton("Offers");
	buttonContract= new JButton("Contracts");
	panel.add(buttonContact);
	panel.add(buttonOffer);
	panel.add(buttonContract);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);	
    frame.pack();
   listen();	
}
	
	
	
	private void listen(){
		buttonContact.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.getInstance().openContacts();
			}
						
		});
		
		buttonOffer.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui.getInstance().openOffers();
			}
						
		});
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	}


