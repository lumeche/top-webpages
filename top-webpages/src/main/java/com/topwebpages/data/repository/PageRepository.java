package com.topwebpages.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topwebpages.data.model.Page;

public interface PageRepository extends JpaRepository<Page, String> {

}
