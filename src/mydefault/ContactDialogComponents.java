package mydefault;
import interfaces.Dialogable;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import checker.DateChecker;
import checker.NameChecker;
import checker.PhoneChecker;

import databinder.DataBinder;
import dataobjects.Contact;


public class ContactDialogComponents implements Dialogable<Contact>{
	private JTextField name = null, date=null, nName=null, phone=null;
	private JButton  buttonOk= null;
	private JLabel labelName = null, labelDate= null, labelNName=null, labelPhone=null;
	private JLabel errorLabel = null;
	private JCheckBox customer;
	private JLabel labelCustomer;
	ContactDialogComponents(){
		
		name = new JTextField("",20);
        labelName = new JLabel("Name");
        nName = new JTextField("",20);
        labelNName = new JLabel("Nachname");
        phone = new JTextField("",20);
        labelPhone = new JLabel("Telephonnummmer");
        date = new JTextField("",10);
        labelDate = new JLabel("Datum");
        customer = new JCheckBox("");
        labelCustomer = new JLabel("is Customer?");
        buttonOk =new JButton("Ok");
        errorLabel= new JLabel("",10);
	}
	public JTextField getnName() {
		return nName;
	}
	public JCheckBox getCustomer() {
		return customer;
	}
	public JLabel getLabelCustomer() {
		return labelCustomer;
	}
	public JButton getButtonOk(){return buttonOk;}
	public JTextField getName(){return name;}
	public JTextField getDate(){return date;}
	public JTextField getNName(){return nName;}
	public JTextField getPhone(){return phone;}
	public JLabel getLabelName(){return labelName;}
	public JLabel getLabelNName(){return labelNName;}
	public JLabel getLabelPhone(){return labelPhone;}
	public JLabel getLabelDate(){return labelDate;}
	public JLabel getErrorLabel(){return errorLabel;}
	
	public boolean bindTo(Contact argContact){
		DataBinder mybinder = new DataBinder();
		ErrorHandler.getInstance().resetError();
		argContact.setName(mybinder.bindTextfieldToString(name, new NameChecker()));
		argContact.setNName(mybinder.bindTextfieldToString(nName, new NameChecker()));
		argContact.setPhone(mybinder.bindTextfieldToString(phone, new PhoneChecker()));
		argContact.setDate(mybinder.bindTextfieldToDate(date, new DateChecker()));
		argContact.setCustomer(mybinder.bindCheckBoxToBoolean(customer));
		
		return ErrorHandler.getInstance().isValid();
		
	}
	public boolean bindFrom(Contact argContact){
		DataBinder mybinder =new DataBinder();
		ErrorHandler.getInstance().resetError();

		name=mybinder.bindStringToTextField(argContact.getName());
		nName=mybinder.bindStringToTextField(argContact.getNName());
		phone=mybinder.bindStringToTextField(argContact.getPhone());
		date=mybinder.bindDateToTextField(argContact.getDate());
		customer=mybinder.bindBooleanToCheckBox(argContact.isCustomer());
		
		return ErrorHandler.getInstance().isValid();
	}
}
