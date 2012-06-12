package mydefault;

import java.io.BufferedWriter;
import java.io.FileWriter;

import models.Config;






public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Config.getInstance();
		Gui.getInstance();
		
	
	}

}
