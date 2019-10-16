package com.springboothello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboothello.entity.Student;
import com.springboothello.repositories.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public Student findBystudentName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepo.findBystudentName(studentName);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public List<Student> findAllBystudentName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepo.findAllBystudentName(studentName);
	}

}
