package mydefault;

import models.Config;
import models.DummyDatabase;
import interfaces.DataAccessable;


public class Database {
	static private Database myinstance = null;
	static DataAccessable mycon = null;
	private Database(){
		if (Config.getInstance().isDummy())mycon = new DummyDatabase();
		else mycon = new MysqlDatabase();
	}
	static public DataAccessable getInstance()
	{
	 if ( myinstance == null )
		myinstance = new Database();
	 return mycon;
	}
	
	
	
	
	}
