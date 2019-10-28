package com.springboothello.service;

import java.util.List;

import org.springframework.stereotype.Component;

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

@Component
public interface StudentInfoService {

	List<StudentInfo> findAll();

	StudentInfo findByinfoId(Long infoid);

	public void saveStudent(StudentInfo studentInfo);

	String delete(StudentInfo studentInfo);
}
