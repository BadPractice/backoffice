package TableModels;

import java.text.SimpleDateFormat;

import dataobjects.Offer;
import dataobjects.Rechnung;
import models.SimpleModel;

public class RechnungTableModel extends SimpleModel<Rechnung> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDateFormat ft = new SimpleDateFormat ("dd.mm.yyyy");
	 
	  @Override
	  public int getColumnCount() {
	    return 3;
	  }
	  public Rechnung getRow(int row){return textData.get(row);}
	  public Object getValueAt(int row, int column) {
	    switch(column){
	    case 0:
	    	//System.out.println("presenting" + textData.get(row).getId());
	    	return textData.get(row).getId();
		case 1:
	    	return textData.get(row).getSum();
		case 2:
			return textData.get(row).getDate();
	  }
		return column;
	  
	  }}
