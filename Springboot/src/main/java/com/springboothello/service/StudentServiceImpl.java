package com.springboothello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboothello.entity.Student;
import com.springboothello.repositories.StudentRepo;

public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentBasicRepo;
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentBasicRepo.findAll();
	}

	@Override
	public List<Student> findBystudentName(String studentName) {
		// TODO Auto-generated method stub
		return findBystudentName(studentName);
	}

	@Override
	public Student findBystudentId(Long studentId) {
		// TODO Auto-generated method stub
		return studentBasicRepo.findBystudentId(studentId);
	}

	@Override
	public Student deleteBystudentId(Long studentId) {
		// TODO Auto-generated method stub
		return studentBasicRepo.deleteBystudentId(studentId);
	}

	@Override
	public Student findBystudentCode(String studentCode) {
		// TODO Auto-generated method stub
		return findBystudentCode(studentCode);
	}
	
	
	
}
