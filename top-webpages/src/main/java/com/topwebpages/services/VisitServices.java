package com.topwebpages.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.topwebpages.data.model.Visit;
import com.topwebpages.data.repository.PageRepository;
import com.topwebpages.data.repository.VisitRepository;

@Controller
public class VisitServices {

	@Autowired
	private PageRepository pageRepository;
	
	@Autowired 
	private VisitRepository visitRepository;

 
	public List<Visit> getTopVisitByWeek(Date dayInWeek){
		return null;
	}
}
