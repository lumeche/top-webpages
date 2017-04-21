package com.topwebpages.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topwebpages.data.model.Page;
import com.topwebpages.data.model.Visit;
import com.topwebpages.data.repository.PageRepository;
import com.topwebpages.data.repository.VisitRepository;
@RestController
public class PageRanking {

	Logger logger = LoggerFactory.getLogger(PageRanking.class);
	@Autowired
	private  PageRepository pageRepository;
	
	@Autowired
	private VisitRepository visitRepository;
			
	@RequestMapping("/pages")
	public List<Page> getPage() {
		return pageRepository.findAll();
	}
	
	@RequestMapping("/visits")
	public List<Visit> getAllVisits(){
		return visitRepository.findAll(); 
	}
	
	@RequestMapping("/topVisits")
	public List<Visit> getTopVisit(){
		return null;
	}
}
