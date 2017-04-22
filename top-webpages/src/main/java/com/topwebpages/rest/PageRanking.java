package com.topwebpages.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topwebpages.data.model.Visit;
import com.topwebpages.data.repository.VisitRepository;
import com.topwebpages.services.VisitServices;

@RestController
public class PageRanking {

	Logger logger = LoggerFactory.getLogger(PageRanking.class);

	@Value("${date.format}")
	private String dateFormat;
	
	@Autowired
	private VisitRepository visitRepository;

	@Autowired
	private VisitServices visitServices;

	@RequestMapping("/visits")
	public List<Visit> getAllVisits() {
		return visitRepository.findAll();
	}
	@RequestMapping("/visit/{visitId}")
	public Visit getVisit(@PathVariable Integer visitId) {
		return visitRepository.findOne(visitId);
	}
	
	@RequestMapping("/topVisits/{dateInWeek}")
	public List<Visit> getTopVisit(@PathVariable String dateInWeek) {
		try {
			Date date = new SimpleDateFormat(dateFormat).parse(dateInWeek);
			logger.info("Date received {}", date);
			return visitServices.getTopVisitByWeek(date);
		} catch (ParseException e) {
			logger.error("Error parsing the date {}", dateInWeek, e);
			return null;
		}
	}
}
