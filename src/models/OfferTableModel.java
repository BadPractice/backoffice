package models;

import interfaces.Tableable;

import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import dataobjects.Contact;
import dataobjects.Offer;

public class OfferTableModel extends SimpleModel<Offer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDateFormat ft = new SimpleDateFormat ("dd.mm.yyyy");
	 // Vector<Offer> textData = new Vector<Offer>();
	 
	  @Override
	  public int getRowCount() {
	    return (textData.size());
	  }
	  @Override
	  public int getColumnCount() {
	    return 7;
	  }
	  public Offer getRow(int row){return textData.get(row);}
	  public Object getValueAt(int row, int column) {
	    switch(column){
	    case 0:
	    	//System.out.println("presenting" + textData.get(row).getId());
	    	return textData.get(row).getId();
		case 1:
	    	return textData.get(row).getChance();
		case 2:
			return textData.get(row).getSum();
		case 3:
			return ft.format(textData.get(row).getDate());
		case 4: 
			return textData.get(row).getDuration();
		case 5:
			return textData.get(row).getProjectId();
		case 6:
			return textData.get(row).getCustomerId();
	    }
		return null;
	  }


		
	}

