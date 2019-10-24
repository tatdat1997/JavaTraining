package com.springboothello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboothello.entity.Student;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentRepository interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value = "SELECT * FROM student ORDER BY student_id ASC", nativeQuery = true)
	List<Student> findAllByAsc();

	@Query(value = "SELECT * FROM student ORDER BY student_id DESC", nativeQuery = true)
	List<Student> findAllByDesc();

	Student findBystudentId(Long studentId);

	@Query(value = "SELECT * FROM student WHERE student_name like %?1%", nativeQuery = true)
	List<Student> findBystudentName(String studentName);

	@Query(value = "SELECT * FROM student,student_info WHERE student.student_id = student_info.student_id and student_info.date_of_birth BETWEEN ?1 and ?2", nativeQuery = true)
	List<Student> findBydateOfBirth(String From, String To);

	Student findBystudentCode(String studentCode);

	Student deleteBystudentId(Long studentId);

}
