package com.springboothello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.StudentInfo;

public interface StudentInfoRepo extends JpaRepository<StudentInfo,Integer>{
	StudentInfo findByStudentId(Integer studentId);

	List<StudentInfo> findAll();

}
