package com.springboothello.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboothello.entity.Student;
import org.springframework.data.domain.Pageable;


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
@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable> {
	
	
	@Query(name = "HQL_GET_ALL_STUDENT", nativeQuery = true)
	List<Student> findAllByAsc();

	@Query(value = "SELECT * FROM student ORDER BY student_id DESC", nativeQuery = true)
	List<Student> findAllByDesc();

	Student findBystudentId(Long studentId);

	@Query(name = "HQL_GET_ALL_STUDENT_BY_NAME", nativeQuery = true)
	List<Student> findBystudentName(@Param("name") String studentName);

	@Query(value = "SELECT * FROM student,student_info WHERE student.student_id = student_info.student_id and student_info.date_of_birth BETWEEN ?1 and ?2", nativeQuery = true)
	List<Student> findBydateOfBirth(String From, String To);

	Student findBystudentCode(String studentCode);

	Student deleteBystudentId(Long studentId);
	
	@Query(value = "SELECT * FROM student ORDER BY student_id ASC",nativeQuery = true)  
	List<Student> findAllStudent(Pageable pageable);
	
	@Query(value = "SELECT * FROM student WHERE student_name like %?1%", nativeQuery = true)
	List<Student> findByStudentName(String name, Pageable pageable);

	@Query(value = "SELECT count(*) as 'total' FROM student WHERE student_name like %?1%", nativeQuery = true)
	Long countByName(String name);
	
}
