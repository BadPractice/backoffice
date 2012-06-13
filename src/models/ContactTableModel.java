package models;

import java.text.SimpleDateFormat;
import java.util.Vector;

import dataobjects.Contact;

public class ContactTableModel extends SimpleModel<Contact>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
	  
	  @Override
	  public int getRowCount() {
	    return (textData.size());
	  }
	  @Override
	  public int getColumnCount() {
	    return 6;
	  }
	//  public Contact getRow(int row){return textData.get(row);}
	  public Object getValueAt(int row, int column) {
	    switch(column){
	    case 0:
	    	//System.out.println("presenting" + textData.get(row).getId());
	    	return  textData.get(row).getId();
		case 1:
	    	return textData.get(row).getName();
		case 2:
			return textData.get(row).getNName();
		case 3:
			return textData.get(row).getPhone();
		case 4:
			return ft.format(textData.get(row).getDate());
		case 5:
			if(textData.get(row).isCustomer()) return "Yes";
			return "No";
	    }
		return null;
	  }
}
