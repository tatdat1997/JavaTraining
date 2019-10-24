package com.springboothello.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboothello.entity.Student;
import com.springboothello.entity.StudentInfo;
import com.springboothello.service.StudentInfoService;
import com.springboothello.service.StudentService;

@Controller
public class TransactionController {

	@Autowired
	private StudentInfoService studentInfoService;

	@Autowired
	private StudentService studentService;

	
	@RequestMapping(value = "/transaction")
	public String logout() {
		Student st1 =new Student(Long.valueOf("18"), "Student 1", "Student 1");
		StudentInfo stif1 = new StudentInfo(Long.valueOf("18"), st1, "aaaa", 9.35, "26/01/1997");
		studentInfoService.save(stif1);
		return "";
	}
}
