package DialogComponents;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import models.ErrorHandler;

import checker.DateChecker;
import checker.NumberChecker;

import databinder.DataBinder;
import dataobjects.Rechnung;
import interfaces.Dialogable;

public class RechnungDialogComponents implements Dialogable<Rechnung> {
	JLabel sumLabel, dateLabel, errorLabel;
	JTextField sum, date;
	JButton buttonOk;
	public RechnungDialogComponents(){
		sumLabel= 	new JLabel("Sum");
		sum= 		new JTextField("",10);
		dateLabel=	new JLabel("Date");
		date=		new JTextField("",10);
        buttonOk=	new JButton("Ok");
        errorLabel= new JLabel("",10);
	}
	@Override
	public boolean bindFrom(Rechnung arg) {
		ErrorHandler.getInstance().clearError();
		DataBinder mybinder = new DataBinder();
		sum= mybinder.bindIntegerToTextField(arg.getSum());
		date= mybinder.bindDateToTextField(arg.getDate());
		return ErrorHandler.getInstance().isValid();
	}

	@Override
	public boolean bindTo(Rechnung arg) {
		ErrorHandler.getInstance().clearError();
		DataBinder mybinder = new DataBinder();
		arg.setSum(mybinder.bindTextfieldToInteger(sum, new NumberChecker()));
		arg.setDate(mybinder.bindTextfieldToDate(date, new DateChecker()));
		return ErrorHandler.getInstance().isValid();
	}

	@Override
	public JButton getButtonOk() {
		return buttonOk;
	}

	@Override
	public JLabel getErrorLabel() {
		return errorLabel;
	}
	public JLabel getSumLabel() {
		return sumLabel;
	}
	public JLabel getDateLabel() {
		return dateLabel;
	}
	public JTextField getSum() {
		return sum;
	}
	public JTextField getDate() {
		return date;
	}

}
