

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import models.BackModel;
import models.Contact;
import models.SimpleModel;

public class ContactBrowser extends JPanel implements ActionListener
 {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<String> col = null;
	 LayoutManager mgr = null;
	 JTable mytable = null;
	 JButton  buttonSearch= null, buttonEdit= null, buttonDelete=null, buttonAdd=null;
	 JFrame frame = null;
	 SimpleModel model = null; 
	 JTextField inName = null;
	  //DefaultTableModel model= null;
//	 SimpleModel aaa = null;
	 
	 ContactBrowser( ) 
	{
		
		
		buttonSearch= new JButton("Search");
		buttonDelete= new JButton("Delete");
		buttonEdit= new JButton("Edit");
		buttonAdd= new JButton("Add");
		frame = new JFrame("Kontakte");
		col= new Vector<String>();
		col.add("id");
		col.add("name");
		//mytable.add
		model = new SimpleModel();
		System.out.println("fuuuu");
		//model = new DefaultTableModel(col, Businesslogic.getInstance().getContact());
		mytable = new JTable(model);
		setLayout(new BorderLayout());
		//plugging components together
		frame.getContentPane().add(this);
		add(buttonSearch);
		add(buttonEdit);
		add(buttonDelete);
		add(buttonAdd);
		add(mytable);
		//positioning
		setLayout(mgr );
		frame.setSize(800,600);
		mytable.setLocation(10, 10);
		mytable.setSize(500, 500);
		mytable.setVisible(true);
		//mytable.setS electionMode(ListSelectionModel.SINGLE_SELECTION);

		buttonSearch.setLocation(520, 10);
		buttonSearch.setSize(270, 100);
		buttonDelete.setLocation(520, 120);
		buttonDelete.setSize(270, 100);
		buttonEdit.setLocation(520, 230);
		buttonEdit.setSize(270, 100);
		buttonAdd.setLocation(520, 340);
		buttonAdd.setSize(270, 100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);	
	    //frame.pack();
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
				setData();
			}
						
		});
		
		buttonDelete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Contact toDelete;
				toDelete = model.getRow(mytable.getSelectedRow());
				Businesslogic.getInstance().deleteContact(toDelete);
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