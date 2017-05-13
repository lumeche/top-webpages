package com.topwebpages.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.topwebpages.data.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer>{
	public List<Visit> findByWeekFrom(String weekFrom,Pageable pageable);
	public List<Visit> findByUrl(String url);
}
