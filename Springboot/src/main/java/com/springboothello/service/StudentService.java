package com.springboothello.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.springboothello.entity.Student;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentService interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public interface StudentService {

	public List<Student> findAll();

	List<Student> findAllByAsc();

	List<Student> findAllByDesc();

	Student findBystudentId(Long studentId);

	@Query(value = "SELECT * FROM student WHERE student_name like %?1%", nativeQuery = true)
	List<Student> findBystudentName(String studentName);

	Student findBystudentCode(String studentCode);

	Student deleteBystudentId(Long studentId);
	
	List<Student> findAllStudent(Pageable pageable);
	
	List<Student> findByStudentName(String name, Pageable pageable);
	
	Long count();
	
	@Query(value = "SELECT count(*) as 'total' FROM student WHERE student_name like %?1%", nativeQuery = true)
	Long countByName(String name);
}
