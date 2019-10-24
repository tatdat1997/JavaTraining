package com.springboothello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.StudentInfo;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfoRepository interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer> {

	StudentInfo findByinfoId(Long info_id);

	List<StudentInfo> findAll();

}
