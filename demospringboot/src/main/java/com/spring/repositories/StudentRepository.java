package com.spring.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable>{
	@Query(name = "HQL_GET_ALL_STUDENT_BY_NAME", nativeQuery = true)
	List<Student> findBystudentName(@Param("name") String studentName);
	
	@Query(name = "HQL_GET_ALL_STUDENT", nativeQuery = true)
	List<Student> findAllByAsc();
	
}
