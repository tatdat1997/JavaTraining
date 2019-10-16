package com.springboothello.service;

import java.util.List;
import com.springboothello.entity.StudentInfo;

public interface StudentInfoService {
	StudentInfo findByStudentId(Integer studentId);
	
	List<StudentInfo> findAll();
}
