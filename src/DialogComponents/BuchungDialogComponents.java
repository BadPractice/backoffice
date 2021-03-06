package DialogComponents;

import interfaces.Dialogable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mydefault.ErrorHandler;

import checker.DateChecker;
import checker.NumberChecker;
import databinder.DataBinder;
import dataobjects.Buchung;
import dataobjects.Buchung;

public class BuchungDialogComponents implements Dialogable<Buchung> {
	JLabel sumLabel, dateLabel, errorLabel, rechnungIdLabel;
	JTextField sum, date, rechnungId;
	JButton buttonOk;
	public BuchungDialogComponents(){
		sumLabel= 	new JLabel("Sum");
		sum= 		new JTextField("",10);
		dateLabel=	new JLabel("Date");
		date=		new JTextField("",10);
		rechnungIdLabel= new JLabel("Rechnungs ID");
		rechnungId= new JTextField("",10);
        buttonOk=	new JButton("Ok");
        errorLabel= new JLabel("",10);
	}
	@Override
	public boolean bindFrom(Buchung arg) {
		ErrorHandler.getInstance().clearError();
		DataBinder mybinder = new DataBinder();
		sum= mybinder.bindIntegerToTextField(arg.getSum());
		rechnungId= mybinder.bindIntegerToTextField(arg.getRechnungId());
		date= mybinder.bindDateToTextField(arg.getDate());
		return ErrorHandler.getInstance().isValid();
	}

	@Override
	public boolean bindTo(Buchung arg) {
		ErrorHandler.getInstance().clearError();
		DataBinder mybinder = new DataBinder();
		arg.setSum(mybinder.bindTextfieldToInteger(sum, new NumberChecker()));

		arg.setDate(mybinder.bindTextfieldToDate(date, new DateChecker()));
		arg.setRechnungId(mybinder.bindTextfieldToInteger(rechnungId, new NumberChecker()));
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
	public JLabel getRechnungIdLabel() {
		return rechnungIdLabel;
	}
	public JTextField getRechnungId() {
		return rechnungId;
	}
	public JTextField getDate() {
		return date;
	}

}
