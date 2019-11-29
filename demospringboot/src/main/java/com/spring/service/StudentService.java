package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.model.Student;

@Component
public interface StudentService {

	public void saveStudent(Student student);
	
	List<Student> findBystudentName(String studentName);
	
	Student findByStudentId(int studentId);
	
}
