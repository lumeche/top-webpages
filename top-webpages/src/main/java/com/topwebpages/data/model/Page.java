package com.topwebpages.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Page {

	@Id
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
