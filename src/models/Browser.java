package models;

import interfaces.Tableable;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import mydefault.ContactBrowser;

public class Browser<t> {
	protected JTable mytable = null;
	protected JButton  buttonSearch= null, buttonEdit= null, buttonDelete=null, buttonAdd=null;
	 protected JFrame frame = null;
	 //protected SimpleModel  model = null; 
	 protected JPanel panel= null;

public void initLayout(SimpleModel  model){
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
}
