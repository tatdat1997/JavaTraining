package com.springboothello.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.springboothello.entity.Student;
import com.springboothello.repositories.StudentRepo;

@Controller
public class ListStudentController {

	
	@Autowired
	private StudentRepo studentRepo;
		
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public String listStudent(Model model){
	    List<Student> listStudent = studentRepo.findAllByAsc();
	    // Add listStudent in Model to transmission to the interface
	    model.addAttribute("listStudent", listStudent);
	    return "ListStudent";
	}
	
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	public String searchStudent(WebRequest request, Model model){
		
		String studentName = request.getParameter("StudentName");
		String studentCode = request.getParameter("StudentCode");
		String fromBirthday = request.getParameter("Birthday");
		String toBirthday = request.getParameter("toBirthday");
		List<Student> student = new ArrayList<Student>();
		//Find student by Parameter
		if(studentName.isEmpty() && studentCode.isEmpty() 
				&& fromBirthday.isEmpty() && toBirthday.isEmpty()) {
			return "redirect:/listStudent";
		}else {
			if(!studentName.isEmpty()) {
				List<Student> studentByName = studentRepo.findBystudentName(studentName);
				if(!studentByName.isEmpty()) {
					student.addAll(studentByName);
				}
			}
			Student studentByCode = studentRepo.findBystudentCode(studentCode);
			List<Student> studentByBirth = studentRepo.findBydateOfBirth(fromBirthday, toBirthday);
			if(studentByCode!=null) {
				student.add(studentByCode);
			}
			if(!studentByBirth.isEmpty()) {
				student.addAll(studentByBirth);
			}
		}
	    model.addAttribute("listStudent",student);
	    return "ListStudent";
	}
	
	@RequestMapping(value = "/abcabc", method = RequestMethod.GET)
	public String searchStudent(Model model){

	    List<Student> listStudent = studentRepo.findAll();
	    // Add listStudent in Model to transmission to the interface
	    model.addAttribute("listStudent", listStudent);
	    return "ListStudent";
	}
	

}
