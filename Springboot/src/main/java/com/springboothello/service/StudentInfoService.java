package com.springboothello.service;

import java.util.List;

import com.springboothello.entity.StudentInfo;

public interface StudentInfoService {
	List<StudentInfo> findAll();
	
	StudentInfo findByinfoId(Long infoid);
	
	StudentInfo deleteByinfoId(Long infoid);
	
	
}
