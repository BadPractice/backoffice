package mydefault;

import interfaces.Dialogable;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import checker.DateChecker;
import checker.FloatChecker;
import checker.FreeTextChecker;
import checker.NumberChecker;

import databinder.DataBinder;
import dataobjects.Offer;

public class OfferDialogComponents implements Dialogable<Offer> {
//	OfferDialogComponents(){};
	private JButton  buttonOk= null;
	private JLabel labelChance , labelSum, labelDate, labelDuration, labelProjectId,labelCustomerId;
	private JLabel errorLabel = null;
	private JTextField nName;
	private JTextField chance, sum, date, duration,projectId,customerId;
	
	OfferDialogComponents(){
		

		labelChance= new JLabel("chance");
		chance = new JTextField("",20);
        labelSum = new JLabel("Sum");
        sum = new JTextField("",20);
        labelDate = new JLabel("Begin");
        date = new JTextField("",20);
        labelDuration = new JLabel("Duration");
        duration = new JTextField("",10);
        labelProjectId = new JLabel("Projekt Id");
        projectId= new JTextField("",10);
        labelCustomerId = new JLabel("Customer Id");
        customerId= new JTextField("",10);
        buttonOk =new JButton("Ok");
        errorLabel= new JLabel("",10);
	}
	
	public JLabel getLabelChance() {
		return labelChance;
	}

	public void setLabelChance(JLabel labelChance) {
		this.labelChance = labelChance;
	}

	public JLabel getLabelSum() {
		return labelSum;
	}

	public void setLabelSum(JLabel labelSum) {
		this.labelSum = labelSum;
	}

	public JLabel getLabelDate() {
		return labelDate;
	}

	public JLabel getLabelDuration() {
		return labelDuration;
	}

	public JLabel getLabelProjectId() {
		return labelProjectId;
	}

	public JLabel getLabelCustomerId() {
		return labelCustomerId;
	}

	public JTextField getChance() {
		return chance;
	}

	public JTextField getSum() {
		return sum;
	}

	public JTextField getDate() {
		return date;
	}

	public JTextField getDuration() {
		return duration;
	}

	public JTextField getProjectId() {
		return projectId;
	}

	public JTextField getCustomerId() {
		return customerId;
	}

	public JButton getButtonOk() {
		return buttonOk;
	}

	public void setButtonOk(JButton buttonOk) {
		this.buttonOk = buttonOk;
	}

	public JLabel getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}

	public JTextField getnName() {
		return nName;
	}

	public void setnName(JTextField nName) {
		this.nName = nName;
	}


	
	public boolean bindTo(Offer arg){
		DataBinder mybinder = new DataBinder();
		boolean errors = true; //if any field is invalid it will bee set to false
		arg.setChance(mybinder.bindTextfieldToFloat(chance, new FloatChecker()));
        arg.setSum(mybinder.bindTextfieldToInteger(sum, new NumberChecker()));
        arg.setDate(mybinder.bindTextfieldToDate(date, new DateChecker()));
        arg.setDuration(mybinder.bindTextfieldToString(duration, new FreeTextChecker())); 
        arg.setProjectId(mybinder.bindTextfieldToInteger(projectId, new NumberChecker()));
        arg.setCustomerId(mybinder.bindTextfieldToInteger(customerId, new NumberChecker()));
		return errors;
		
	}
	public boolean bindFrom(Offer arg){
		boolean error = true;
		DataBinder mybinder=new DataBinder();
		chance =  mybinder.bindFloatToTextField(arg.getChance());
		sum = mybinder.bindIntegerToTextField(arg.getSum());
		date = mybinder.bindDateToTextField(arg.getDate());
		duration = mybinder.bindStringToTextField(arg.getDuration());
		projectId = mybinder.bindIntegerToTextField(arg.getProjectId());
		customerId = mybinder.bindIntegerToTextField(arg.getCustomerId());
			//phone.setText(arg.getPhone());
		return error;
	}

	


}
