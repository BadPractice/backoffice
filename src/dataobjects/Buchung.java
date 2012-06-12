package dataobjects;

import java.sql.Date;

public class Buchung {
	private Integer id, sum, rechnungId;
	public Integer getRechnungId() {
		return rechnungId;
	}
	public void setRechnungId(Integer rechnungId) {
		this.rechnungId = rechnungId;
	}
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
