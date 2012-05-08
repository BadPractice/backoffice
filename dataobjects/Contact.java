package dataobjects;

import java.sql.Date;

public class Contact {
	private Integer id;
	private String name = null,nName=null, phone=null;
	private Date date= null;
	private boolean isCustomer;
	public Contact(){
		id=null;
	}
	//public bindContact
	public Integer getId(){return id;}
	public boolean setId(Integer argId){
		id=argId;
		return true;
	}
	public boolean setName(String argName){
		name=argName;
		return true;
	}
	public boolean setPhone(String argPhone){
		phone=argPhone;
		return true;
	}
	public boolean setDate(Date argDate){
		date=argDate;
		return true;
	}
	public boolean setNName(String argNName){
		nName=argNName;
		return true;
	}
	public String getName(){return name;}
	public String getNName(){return nName;}
	public String getPhone(){return phone;}
	public Date getDate() {return date;}
}
