package browserDialog;

import interfaces.Dialogable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.BrowserDialog;
import models.Businesslogic;
import DialogComponents.BuchungDialogComponents;
import dataobjects.Buchung;
import dataobjects.Buchung;

public class InBuchungBrowserDialog extends BrowserDialog<Buchung>{
	private static final long serialVersionUID = 1L;
	BuchungDialogComponents components = null;
 public InBuchungBrowserDialog(Buchung argBuchung) 
     { 
     components = new BuchungDialogComponents();
     super.doBasics(argBuchung, components);
     components.bindFrom(dataObject);
     //adding fields to panel
     panel.add(components.getSumLabel());
     panel.add(components.getSum());
     panel.add(components.getDateLabel());
     panel.add(components.getDate());
     panel.add(components.getRechnungIdLabel());
     panel.add(components.getRechnungId());
     setModal(true);
     listen();
     pack();
     setVisible( true );          
 } 
 private void listen(){
		components.getButtonOk().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(components.bindTo(dataObject))
				{
					if(dataObject.getId()==null)
						Businesslogic.getInstance().addInBuchung(dataObject);
					else
						Businesslogic.getInstance().updateInBuchung(dataObject);
					endDialog();
				}
				return;
					
			}
						
		});
		
	}
}
