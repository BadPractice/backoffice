package models;

import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import dataobjects.Contact;


@SuppressWarnings("serial")
public
class SimpleModel extends AbstractTableModel {
	SimpleDateFormat ft = new SimpleDateFormat ("dd.mm.yyyy");
	  Vector<Contact> textData = new Vector<Contact>();
	  private String[] columnNames = {"ID", "first name", "last name","phone number","date"};
	 
	  @Override
	  public String getColumnName(int column) {
		    return columnNames[column];
		}
	  
	  public void clearText(){
		  System.out.println(columnNames[1]);
		  textData.clear();
		  fireTableDataChanged();
	  }
	  public void addText(Vector <Contact> text) {
	    textData= text;
	    fireTableDataChanged();
	  }
	  @Override
	  public int getRowCount() {
	    return (textData.size());
	  }
	  @Override
	  public int getColumnCount() {
	    return 5;
	  }
	  public Contact getRow(int row){return textData.get(row);}
	  public Object getValueAt(int row, int column) {
	    switch(column){
	    case 0:
	    	//System.out.println("presenting" + textData.get(row).getId());
	    	return textData.get(row).getId();
		case 1:
	    	return textData.get(row).getName();
		case 2:
			return textData.get(row).getNName();
		case 3:
			return textData.get(row).getPhone();
		case 4:
			return ft.format(textData.get(row).getDate());
	    }
		return null;
	  }
}
