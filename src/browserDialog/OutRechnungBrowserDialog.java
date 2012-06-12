package browserDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DialogComponents.RechnungDialogComponents;
import dataobjects.Rechnung;
import models.BrowserDialog;
import models.Businesslogic;

public class OutRechnungBrowserDialog extends BrowserDialog<Rechnung> {

	private static final long serialVersionUID = 1L;
	RechnungDialogComponents components = null;
 public OutRechnungBrowserDialog(Rechnung argRechnung) 
     { 
     components = new RechnungDialogComponents();
     super.doBasics(argRechnung, components);
     components.bindFrom(dataObject);
     //adding fields to panel
     panel.add(components.getSumLabel());
     panel.add(components.getSum());
     panel.add(components.getDateLabel());
     panel.add(components.getDate());
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
						Businesslogic.getInstance().addOutRechnung(dataObject);
					else
						Businesslogic.getInstance().updateOutRechnung(dataObject);
					endDialog();
				}
				return;
					
			}
						
		});
		
	}
}
