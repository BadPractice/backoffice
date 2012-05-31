package dataobjects;

import java.sql.Date;

public class Offer {
Integer id;
Float chance;
Integer sum;
Date date;
String duration;
public Integer getProjectId() {
	return projectId;
}
public void setProjectId(Integer projectId) {
	this.projectId = projectId;
}
Integer projectId = null;
Integer getId(){return id;}
Float getChance(){return chance;}
Integer getSum(){return sum;}
Date getDate(){return date;}
String getDuration(){return duration;}
public void setId(Integer id) {
	this.id = id;
}
public void setChance(Float chance) {
	this.chance = chance;
}
public void setSum(Integer sum) {
	this.sum = sum;
}
public void setDate(Date date) {
	this.date = date;
}
public void setDuration(String duration) {
	this.duration = duration;
}

}
