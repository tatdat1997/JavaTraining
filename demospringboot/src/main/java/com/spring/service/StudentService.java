package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.model.Student;

@Component
public interface StudentService {

	public void save(Student student);
	
	List<Student> findStudent(String studentName);
	
	List<Student> findAllStudentNameByASC();
}
