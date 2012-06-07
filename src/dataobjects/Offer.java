package dataobjects;

import java.sql.Date;

public class Offer {
Integer id;
Float chance;
Integer sum;
Date date;
String duration;
Integer projectId = null;
Integer customerId;
public Integer getProjectId() {
	return projectId;
}
public void setProjectId(Integer projectId) {
	this.projectId = projectId;
}

public Integer getId(){return id;}
public Float getChance(){return chance;}
public Integer getSum(){return sum;}
public Date getDate(){return date;}
public String getDuration(){return duration;}
public void setId(Integer id) {
	this.id = id;
}
public void setChance(Float chance) {
	this.chance = chance;
}
public void setSum(Integer sum) {
	this.sum = sum;
}
public Integer getCustomerId() {
	return customerId;
}
public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}
public void setDate(Date date) {
	this.date = date;
}
public void setDuration(String duration) {
	this.duration = duration;
}

}
