package com.springboothello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboothello.entity.StudentInfo;
import com.springboothello.repositories.StudentInfoRepository;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{

	@Autowired
	StudentInfoRepository studentInfoRepo;
	
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


	@Override
	public StudentInfo save(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		return studentInfoRepo.save(studentInfo);
	}

	@Override
	public String delete(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoRepo.delete(studentInfo);
		return null;
	}



}
