package models;
import interfaces.DataAccessable;
import interfaces.MysqlDatabase;


public class Database {
	static private Database myinstance = null;
	static DataAccessable mycon = null;
	private Database(){
		mycon = new MysqlDatabase();
	}
	static public DataAccessable getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Database();
	 return mycon;
	}
	
	
	
	
	}
