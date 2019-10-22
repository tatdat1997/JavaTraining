package com.springboothello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboothello.entity.StudentInfo;
import com.springboothello.repositories.StudentInfoRepo;

public class StudentInfoServiceImpl implements StudentInfoService{

	@Autowired
	StudentInfoRepo studentInfoRepo;
	
	@Override
	public List<StudentInfo> findAll() {
		// TODO Auto-generated method stub
		return studentInfoRepo.findAll();
	}

	@Override
	public StudentInfo findByinfoId(Long infoid) {
		// TODO Auto-generated method stub
		return findByinfoId(infoid);
	}

	@Override
	public StudentInfo deleteByinfoId(Long infoid) {
		// TODO Auto-generated method stub
		return studentInfoRepo.deleteByinfoId(infoid);
	}



}
