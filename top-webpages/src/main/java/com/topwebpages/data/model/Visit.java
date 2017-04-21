package com.topwebpages.data.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Visit {

	@Id
	@GeneratedValue
	private int visitId;
	
	@OneToOne
	private Page page;
	private Date weekFrom;
	private long visits;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Date getWeekFrom() {
		return weekFrom;
	}
	public void setWeekFrom(Date weekFrom) {
		this.weekFrom = weekFrom;
	}
	public long getVisits() {
		return visits;
	}
	public void setVisits(long visits) {
		this.visits = visits;
	}
	public int getVisitId() {
		return visitId;
	}
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}
	

}
