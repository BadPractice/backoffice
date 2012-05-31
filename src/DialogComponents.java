import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataobjects.Contact;


public class DialogComponents {
	private JTextField name = null, date=null, nName=null, phone=null;
	private JButton  buttonOk= null;
	private JLabel labelName = null, labelDate= null, labelNName=null, labelPhone=null;
	private JLabel errorLabel = null;
	DialogComponents(){
		
		name = new JTextField("",20);
        labelName = new JLabel("Name");
        nName = new JTextField("",20);
        labelNName = new JLabel("Nachname");
        phone = new JTextField("",20);
        labelPhone = new JLabel("Telephonnummmer");
        date = new JTextField("",10);
        labelDate = new JLabel("Datum");
        buttonOk =new JButton("Ok");
        errorLabel= new JLabel("",10);
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
	public JLabel getLabelError(){return errorLabel;}
	@SuppressWarnings("deprecation")
	public boolean bindTo(Contact argContact){
		InputChecker myInputChecker = new InputChecker();
		boolean errors = true; //if any field is invalid it will bee set to false
		Color errorcolor = new Color(255,0,0);
		
		//first name check + bind
		if(myInputChecker.checkName(name.getText()))//checking first name
		{//valid
			argContact.setName(name.getText());
		}
		else
		{//not valid
			errors = false;
			name.setToolTipText("Der Vorname ist ungültig!");
			name.setBackground(errorcolor);
		}
		
		//last name check + bind
		if(myInputChecker.checkName(nName.getText()))//checking last name
		{//valid
			argContact.setNName(nName.getText());
		}
		else
		{//not valid
			errors = false;
			nName.setToolTipText("Der Nachname ist ungültig!");
			nName.setBackground(errorcolor);
		}
		
		//phone  check + bind
		if(myInputChecker.checkPhone(phone.getText()))
		{//valid
			argContact.setPhone(phone.getText());
		}
		else
		{//not valid
			errors = false;
			phone.setToolTipText("Die Telephonnummer ist ungültig");
			phone.setBackground(errorcolor);
		}
		
		//phone number check + binding
		if(myInputChecker.checkPhone(phone.getText()))//checking if phone is valid
		{
			argContact.setPhone(phone.getText());
		}
		else
		{//not valid
			errors = false;
			phone.setToolTipText("Die Telephonnummer ist ungültig!");
			phone.setBackground(errorcolor);
		}
		
		//date check + binding
		if(myInputChecker.checkDate(date.getText()))//checking if date is valid
		{//valid
			String mydate = date.getText();
			String[] mySplitDate = mydate.split("\\.");
			System.out.println(mySplitDate[1]);
			argContact.setDate(new Date(1988,02,22));
	
			
		}
		else
		{//not valid
			errors = false;
			date.setToolTipText("Der Name ist ungültig!");
			date.setBackground(errorcolor);
		}
		return errors;
		
	}
	public boolean bindFrom(Contact argContact){
		boolean error = true;
		SimpleDateFormat ft = new SimpleDateFormat ("dd. MM. yyyy");
		if(argContact.getName()!=null)
			name.setText(argContact.getName());
		if(argContact.getNName()!=null)
			nName.setText(argContact.getNName());
		if(argContact.getPhone()!=null)
			phone.setText(argContact.getPhone());
		if(argContact.getDate()!=null)
			date.setText(ft.format(argContact.getDate()));
		return error;
	}
}
