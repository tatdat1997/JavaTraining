package com.springboothello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
	Student findBystudentName(String studentName);
	
	List<Student> findAllBystudentName(String studentName);
	
	List<Student> findAll();
	
}
