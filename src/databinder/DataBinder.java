package databinder;

import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;

import interfaces.Checkable;

import javax.swing.JTextField;


public class DataBinder {
	public String bindTextfieldToString(JTextField argBox,Checkable<String> argCheck){
		if(argCheck.check(argBox.getText())==false)
		{
			argBox.setBackground(Color.red);
			return null;
		}
		argBox.setBackground(Color.white);
		return argBox.getText();
	}
	
	public Integer bindTextfieldToInteger(JTextField argBox,Checkable<String> argCheck){
		if(argCheck.check(argBox.getText())==false)
		{
			argBox.setBackground(Color.red);
			return null;
		}
		argBox.setBackground(Color.white);
		return Integer.parseInt(argBox.getText());
	}
	
	public Date bindTextfieldToDate(JTextField argBox,Checkable<String> argCheck){
		if(argCheck.check(argBox.getText())==false)
		{
			argBox.setBackground(Color.red);
			return null;
		}
		argBox.setBackground(Color.white);
		String[] mySplitDate = argBox.getText().split("\\.");	
		return Date.valueOf(mySplitDate[2]+"-"+mySplitDate[1]+"-"+mySplitDate[0]);
	}

	public Float bindTextfieldToFloat(JTextField argBox,
			Checkable<String> argCheck) {
		if(argCheck.check(argBox.getText())==false)
		{
			argBox.setBackground(Color.red);
			return null;
		}
		argBox.setBackground(Color.white);
		return new Float(1);
	}
	
	public JTextField bindStringToTextField(String arg){
		if(arg== null)return new JTextField();
		return new JTextField(arg);
	}
	
	public JTextField bindIntegerToTextField(Integer arg){
		if(arg== null)return new JTextField();
		return new JTextField(arg.toString());
	}
	
	public JTextField bindFloatToTextField(Float arg){
		if(arg== null)return new JTextField();
		return new JTextField(arg.toString());
	}

	public JTextField bindDateToTextField(Date arg){
		if(arg== null)return new JTextField();
		SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
		return new JTextField(ft.format(arg).toString());
	}
	}