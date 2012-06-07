package interfaces;

import javax.swing.JButton;
import javax.swing.JLabel;

public interface Dialogable<t> {
	JButton getButtonOk();
    JLabel getErrorLabel();
	boolean bindFrom(t arg);
	boolean bindTo(t arg);
	//Object getId();
}
