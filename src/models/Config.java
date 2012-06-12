package models;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import mydefault.Gui;

public class Config {
	static private Config myinstance = null;
	private boolean isLogging, isDummy;
 private Config(){
	 isLogging = isDummy = false;
	 FileInputStream fstream;
	try {
		fstream = new FileInputStream("config.txt");
	} catch (FileNotFoundException e) {
		return;
	}
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  try {
		while ((strLine = br.readLine()) != null)   {
		  if(strLine.compareTo("logging=on;")==0)isLogging=true;
		  if(strLine.compareTo("dummy=on;")==0)isDummy=true;
		  }
	} catch (IOException e) {
		return;
	}
	  try {
		in.close();
	} catch (IOException e) {
		return;
	}
 }
 
 
 public boolean isLogging() {
	return isLogging;
}


public boolean isDummy() {
	return isDummy;
}


static public Config getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Config();
	 return myinstance;
	}
}
