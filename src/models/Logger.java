package models;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;


public class Logger {
		 static private Logger myinstance = null;

		 private Logger(){
			 
		 }
		 public void push(String text){
			 Writer output = null;
			  File file = new File("Log.txt");
			  try {
				output = new BufferedWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  try {
				output.write(new Date() + " "+ text +"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 
	static public Logger getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Logger();
	 return myinstance;
	}
}
