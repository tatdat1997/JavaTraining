package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring.model.Student;
import com.spring.model.StudentInfo;
import com.spring.service.StudentInfoService;
import com.spring.service.StudentService;

@Controller
public class StudentController {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	@Autowired
	StudentInfoService studentInfoService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String newStudent(Model model) {
		List<StudentInfo> studentLs = studentInfoService.findAll();
		model.addAttribute("ListStudent", studentLs);
		return "Liststudent";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<Student> findStudent(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("===== Find Student =====");
		}
		List<Student> studentLs = studentService.findStudent("Nguyen");
		for (Student student : studentLs) {
			System.out.println(student.PrintInfo());
		}
		return studentLs;
	}
}
