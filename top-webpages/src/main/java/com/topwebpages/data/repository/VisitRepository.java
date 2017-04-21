package com.topwebpages.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topwebpages.data.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer>{
}
