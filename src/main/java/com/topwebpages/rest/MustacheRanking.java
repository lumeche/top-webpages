package com.topwebpages.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topwebpages.data.repository.VisitRepository;

@Controller
public class MustacheRanking {
	private Logger logger = LoggerFactory.getLogger(MustacheRanking.class);
	@Autowired
	private VisitRepository visitRepository;
	
	@RequestMapping("/visits")
	public String getAllVisits(Model model){
		logger.info("Request to get all the visits received");
		model.addAttribute("visits", visitRepository.findAll());
		return "visited";
	}
}
