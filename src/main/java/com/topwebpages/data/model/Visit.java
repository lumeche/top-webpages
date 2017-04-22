package com.topwebpages.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Visit {

	@Id
	@GeneratedValue
	private int visitId;

	private String url;
	private String weekFrom;
	private long visits;

	public Visit() {

	}

	public Visit(int visitId, String page, String weekFrom, long visits) {
		super();
		this.visitId = visitId;
		this.url = page;
		this.weekFrom = weekFrom;
		this.visits = visits;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWeekFrom() {
		return weekFrom;
	}

	public void setWeekFrom(String weekFrom) {
		this.weekFrom = weekFrom;
	}

	public long getVisits() {
		return visits;
	}

	public void setVisits(long visits) {
		this.visits = visits;
	}

	

}
