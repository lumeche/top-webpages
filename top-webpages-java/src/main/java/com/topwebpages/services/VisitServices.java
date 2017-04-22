package com.topwebpages.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.topwebpages.data.model.Visit;
import com.topwebpages.data.repository.VisitRepository;

@Controller
public class VisitServices {

	Logger logger = LoggerFactory.getLogger(VisitServices.class);

	@Value("${date.format}")
	private String dateFormat;

	@Value("${results.number}")
	private int numResults;
	
	@Autowired
	private VisitRepository visitRepository;

	public List<Visit> getTopVisitByWeek(Date dayInWeek) {
		String lastDayOfWeek = getLastDayWeek(dayInWeek);
		logger.info("About to search for visits in {}", lastDayOfWeek);
		PageRequest pageRequest = new PageRequest(0, numResults, Sort.Direction.DESC, "visits");
		return visitRepository.findByWeekFrom(lastDayOfWeek, pageRequest);
	}

	private String getLastDayWeek(Date dayInWeek) {
		Calendar c = Calendar.getInstance();
		c.setTime(dayInWeek);
		int daysOff = Calendar.SATURDAY - c.get(Calendar.DAY_OF_WEEK);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + daysOff);
		return new SimpleDateFormat(dateFormat).format(c.getTime());
	}

	void setVisitRepository(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	void setNumResults(int numResults) {
		this.numResults = numResults;
	}
	

}
