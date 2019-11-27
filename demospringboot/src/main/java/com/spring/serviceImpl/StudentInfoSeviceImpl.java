package com.spring.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.StudentInfo;
import com.spring.repositories.StudentInfoRepository;
import com.spring.service.StudentInfoService;

@Service
@Transactional
public class StudentInfoSeviceImpl implements StudentInfoService{

	@Autowired
	StudentInfoRepository StudentInfoRepository;
	
	
	@Override
	public void save(StudentInfo student) {
		// TODO Auto-generated method stub
		StudentInfoRepository.save(student);
	}


	@Override
	public List<StudentInfo> findAll() {
		// TODO Auto-generated method stub
		return StudentInfoRepository.findAll();
	}

}
