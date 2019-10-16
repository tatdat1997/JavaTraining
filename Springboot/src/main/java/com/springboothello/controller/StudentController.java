package com.springboothello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.springboothello.entity.Student;
import com.springboothello.repositories.StudentRepo;

@Controller
public class StudentController {
	@Autowired
	private StudentRepo studentRepo;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentAll(Model model){
		List<Student> student = studentRepo.findAll();
		
		model.addAttribute("studentList", student);
		return "NewStudent";
	}
	@GetMapping(value = "/student/{studentname}")
	public String userByStudentName(@PathVariable String studentName){
		Student student = studentRepo.findBystudentName(studentName);
		return student.getStudentName();
	}
	
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String  registerUser(WebRequest request, Model model) {
		
//		String studentCode = request.getParameter("StudentCode");
		String studentName = request.getParameter("StudentName");
		List<Student> student = studentRepo.findAllBystudentName(studentName);
		model.addAttribute("studentList", student);
		return "NewStudent";
	}
}
