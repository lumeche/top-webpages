package com.topwebpages.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.h2.util.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.Pageable;

import com.topwebpages.data.model.Visit;
import com.topwebpages.data.repository.VisitRepository;



public class VisitServicesTest {

	private VisitServices testee;

	private VisitRepository visitRepository;
	private List<Visit> visits;

	private String dateFormat="yyyy-MM-dd";

	@Before
	public void setUp() throws Exception {
		testee=new VisitServices();
		visitRepository=mock(VisitRepository.class);
		testee.setVisitRepository(visitRepository);
		testee.setDateFormat(dateFormat);
		testee.setNumResults(1);
	}


	@Test
	public void testSimpleGetTopVisitByWeek() {
		//Given
		Date today = getDate(2016, 1, 6);
		String todayStr=new SimpleDateFormat(dateFormat).format(today);
		visits=new ArrayList<Visit>(Collections.singleton(new Visit(1,"xxx",todayStr,1000)));
		//When
		when(visitRepository.findByWeekFrom(matches(todayStr),any(Pageable.class))).thenReturn(visits);
		List<Visit> obtained = testee.getTopVisitByWeek(today);
		//Then
		assertEquals(1,obtained.size());
		assertEquals(todayStr,obtained.get(0).getWeekFrom());
	}
	
	@Test
	public void testMidleWeekGetTopVisitByWeek() {
		//Given
		Date today = getDate(2016, 1, 8);
		Date lastDayWeek= getDate(2016, 1, 13);
		String lastDayWeekStr=new SimpleDateFormat(dateFormat).format(lastDayWeek);
		visits=new ArrayList<>(Collections.singleton(new Visit(1, "xxx", lastDayWeekStr, 36555)));
		//When		
		when(visitRepository.findByWeekFrom(anyString(),any(Pageable.class))).then(new Answer<List<Visit>>() {
			@Override
			public List<Visit> answer(InvocationOnMock invocation) throws Throwable {
				String dateSent = invocation.getArgumentAt(0, String.class);
				if(StringUtils.equals(dateSent, lastDayWeekStr)){
					return visits;
				}else{
					return null;
				}
			}
		});
		List<Visit> obtained = testee.getTopVisitByWeek(today);
		//then
		assertEquals(1, obtained.size());
		assertEquals(obtained.get(0).getWeekFrom(), lastDayWeekStr);			
	}
	
	@Test
	public void testGetVisitsByUrl(){
		//given
		visits=new ArrayList<>(Collections.singleton(new Visit(1,"xxx.com","2016-05-08",1155)));		
		//when
		when(visitRepository.findByUrl(matches("xxx.com"))).thenReturn(visits);
		List<Visit> positive = testee.getVisitByUrl("xxx.com");
		List<Visit> negative = testee.getVisitByUrl("yyyy");
		//then
		assertEquals(1,positive.size());
		assertEquals("xxx.com", positive.get(0).getUrl());
		assertEquals(0, negative.size());
	}

	private Date getDate(int year,int month,int day) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(year,month, day);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

}
