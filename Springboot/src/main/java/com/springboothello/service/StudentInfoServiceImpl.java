package com.springboothello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboothello.entity.StudentInfo;
import com.springboothello.repositories.StudentInfoRepo;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{
	
	@Autowired
	StudentInfoRepo studentInfoRepo;
	@Override
	public StudentInfo findByStudentId(Integer studentId) {
		// TODO Auto-generated method stub
		return findByStudentId(studentId);
	}

	@Override
	public List<StudentInfo> findAll() {
		// TODO Auto-generated method stub
		return studentInfoRepo.findAll();
	}


}
