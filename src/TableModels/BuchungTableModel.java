package TableModels;

import java.text.SimpleDateFormat;

import models.SimpleModel;

import dataobjects.Buchung;
import dataobjects.Rechnung;

public class BuchungTableModel extends SimpleModel<Buchung>{

	private static final long serialVersionUID = 1L;
	SimpleDateFormat ft = new SimpleDateFormat ("dd.mm.yyyy");
	 
	  @Override
	  public int getColumnCount() {
	    return 4;
	  }
	  public Buchung getRow(int row){return textData.get(row);}
	  public Object getValueAt(int row, int column) {
	    switch(column){
	    case 0:
	    	//System.out.println("presenting" + textData.get(row).getId());
	    	return textData.get(row).getId();
		case 1:
	    	return textData.get(row).getSum();
		case 2:
			return textData.get(row).getDate();
		case 3:
			return textData.get(row).getRechnungId();
	  }
		return column;
	  
	  }

}
