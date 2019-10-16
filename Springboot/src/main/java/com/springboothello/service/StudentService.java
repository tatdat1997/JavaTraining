package com.springboothello.service;

import java.util.List;

import com.springboothello.entity.Student;

public interface StudentService {
	Student findBystudentName(String studentName);
	
	List<Student> findAllBystudentName(String studentName);
	
	List<Student> findAll();
}
