package models;

import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import dataobjects.Contact;



public abstract class SimpleModel<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	protected  Vector<T> textData = new Vector<T>();
	 
	  
	  
	  public void clearText(){
		  textData.clear();
		  fireTableDataChanged();
	  }
	  
	  public void addText(Vector <T> text) {
	    textData= text;
	    fireTableDataChanged();
	  }
	  public int getRowCount() {
	    return (textData.size());
	  }
	  @Override
	  public int getColumnCount() {
	    return 5;
	  }
	  public T getRow(int row){return textData.get(row);}
	  public abstract Object getValueAt(int row, int column);
}
