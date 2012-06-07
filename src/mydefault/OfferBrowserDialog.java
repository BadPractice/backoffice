package mydefault;

import interfaces.Dialogable;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import models.BrowserDialog;
import models.Businesslogic;
import dataobjects.Offer;

public class OfferBrowserDialog extends BrowserDialog<Offer> {
		private static final long serialVersionUID = 1L;
		OfferDialogComponents  components;
	     public OfferBrowserDialog(Offer argOffer) { 
	    	 components = new OfferDialogComponents();
	         super.doBasics(argOffer, components);
	         components.bindFrom(dataObject);
	         //adding fields to panel
	         panel.add(components.getLabelChance());
	         panel.add(components.getChance());
	         panel.add(components.getLabelSum());
	         panel.add(components.getSum());
	         panel.add(components.getLabelDate());
	         panel.add(components.getDate());
	         panel.add(components.getLabelDate());
	         panel.add(components.getDate());
	         panel.add(components.getLabelDuration());
	         panel.add(components.getDuration());
	         panel.add(components.getLabelProjectId());
	         panel.add(components.getProjectId());
	         panel.add(components.getLabelCustomerId());
	         panel.add(components.getCustomerId());



	          
	         // Use invokeLater AFTER the dialog is shown 

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
	 						Businesslogic.getInstance().addOffer(dataObject);
	 					else
	 						Businesslogic.getInstance().updateOffer(dataObject);
	 					endDialog();
	 				}
	 				return;
	 			}
	 						
	 		});
	 		
}}
