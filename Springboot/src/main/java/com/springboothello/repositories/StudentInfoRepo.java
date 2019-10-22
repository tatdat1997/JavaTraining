package com.springboothello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.StudentInfo;

public interface StudentInfoRepo extends JpaRepository<StudentInfo, Integer>{
	StudentInfo findByinfoId(Long info_id);
	
	List<StudentInfo> findAll();	
	
	StudentInfo deleteByinfoId(Long infoid);
}
