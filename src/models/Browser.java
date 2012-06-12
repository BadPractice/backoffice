package models;

import interfaces.WindowControlable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class Browser<t> implements ActionListener, WindowControlable {
	protected JTable mytable = null;
	protected JButton  buttonSearch= null, buttonEdit= null, buttonDelete=null, buttonAdd=null;
	 protected JFrame frame = null;
	 //protected SimpleModel  model = null; 
	 protected JPanel panel= null;

public void initLayout(SimpleModel<t>  model){
	panel=new JPanel(new BorderLayout());
	frame = new JFrame();
	frame.getContentPane().add(panel);
	buttonSearch= new JButton("Refresh");
	buttonDelete= new JButton("Delete");
	buttonEdit= new JButton("Edit");
	buttonAdd= new JButton("Add");
	JPanel buttonPanel = new JPanel(new GridLayout(0,1));
	JPanel tablePanel = new JPanel(new BorderLayout());
	buttonPanel.add(buttonSearch);
	buttonPanel.add(buttonEdit );
	buttonPanel.add(buttonDelete);
	buttonPanel.add(buttonAdd);
	tablePanel.add(mytable,BorderLayout.WEST);
	panel.add(buttonPanel, BorderLayout.EAST);
	panel.add(tablePanel,BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean close() {
	frame.dispose();
	return false;
}
}
