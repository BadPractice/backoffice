package mydefault;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MainGui implements ActionListener{
	JPanel panel= null;
	JFrame frame= null;
	JButton buttonContact= null, buttonOffer = null, buttonContract =null,
	buttonInRechnung, buttonOutRechnung, buttonInBuchung;
	
	MainGui(){
	panel=new JPanel(new GridLayout(0,1));
	
	frame = new JFrame("Main Window");
	frame.getContentPane().add(panel);
	buttonContact= new JButton("Contacts");
	buttonOffer= new JButton("Offers");
	buttonInRechnung= new JButton("InRechnung");
	buttonOutRechnung= new JButton("OutRechnung");
	buttonInBuchung = new JButton("InBuching");
	panel.add(buttonContact);
	panel.add(buttonOffer);
	panel.add(buttonInRechnung);
	panel.add(buttonOutRechnung);
	panel.add(buttonInBuchung);
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
			buttonInRechnung.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					Gui.getInstance().openInRechnung();
				}
						
		});
			
			buttonOutRechnung.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					Gui.getInstance().openOutRechnung();
				}
						
			
		});
			
			buttonInBuchung.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					Gui.getInstance().openInBuchung();
				}
						
		});
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	}


