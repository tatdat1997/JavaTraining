package com.spring.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable>{
	List<Student> findByStudentNameContaining(String studentName);
	
	List<Student> findAll();
	
	Student findByStudentId(Long studentId);
	
}
