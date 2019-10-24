package com.springboothello.service;

import java.util.List;

import com.springboothello.entity.StudentInfo;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfoService interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public interface StudentInfoService {

	List<StudentInfo> findAll();

	StudentInfo findByinfoId(Long infoid);

	StudentInfo save(StudentInfo studentInfo);

	String delete(StudentInfo studentInfo);
}
