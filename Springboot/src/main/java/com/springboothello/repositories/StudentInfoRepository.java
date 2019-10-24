package com.springboothello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.StudentInfo;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer>{
	
	StudentInfo findByinfoId(Long info_id);
	
	List<StudentInfo> findAll();	
		
}
