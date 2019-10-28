package com.springboothello.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboothello.entity.StudentInfo;
import com.springboothello.repositories.StudentInfoRepository;
import com.springboothello.service.StudentInfoService;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfoServiceImpl class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoRepository studentInfoRepo;

	@Override
	public List<StudentInfo> findAll() {
		// TODO Auto-generated method stub
		return studentInfoRepo.findAll();
	}

	@Override
	public StudentInfo findByinfoId(Long infoid) {
		// TODO Auto-generated method stub
		return studentInfoRepo.findByinfoId(infoid);
		
	}

	@Transactional(rollbackFor = {Exception.class})
	public void saveStudent(StudentInfo studentInfo) {
		studentInfoRepo.save(studentInfo);
		Integer.parseInt("");
	}

	@Override
	public String delete(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoRepo.delete(studentInfo);
		return null;
	}


}
