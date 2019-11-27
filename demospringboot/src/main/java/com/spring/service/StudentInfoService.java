package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.model.StudentInfo;

@Component
public interface StudentInfoService {
	
	public void save(StudentInfo student);
	
	List<StudentInfo> findAll();

}
