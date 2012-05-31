package models;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class BackModel extends DefaultTableModel {
	private Vector<Contact>   dataVector_;

	

    //overridden method to add row in the table model
    public void addRow(Contact rowData) {
        insertRow(getRowCount(), rowData);
        fireTableDataChanged();
    }

    public void insertRow(int row, Contact rowData) {
            dataVector_.insertElementAt(rowData, row);
            fireTableRowsInserted(row, row);
       }

    
    
    @Override
    public Object getValueAt(int row, int column) {
        Contact data = dataVector_.get(row);
        switch(column) {
            case 0: return data.getId();
            case 1: return data.getName();
            case 2: return data.getNName();
            case 3: return data.getPhone();
            case 4: return data.getDate();
          //  case 2: return data.year;
            default: return null;
        }
        }
    }
