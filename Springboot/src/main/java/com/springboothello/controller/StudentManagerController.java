package com.springboothello.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.springboothello.entity.Student;
import com.springboothello.entity.StudentInfo;
import com.springboothello.form.StudentForm;
import com.springboothello.repositories.StudentInfoRepo;
import com.springboothello.repositories.StudentRepo;

@Controller
public class StudentManagerController {
	@Autowired
	private StudentInfoRepo studentInfoRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@RequestMapping(value = "/newStudent")
	public String newFormStudent(Model model){
		model.addAttribute("studentForm", new StudentForm());
	    return "NewStudent";
	}
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String newStudent(@Valid StudentForm studentForm, BindingResult result,
    		Model model, HttpServletRequest request){
		if(result.hasErrors()) {
            return "NewStudent";
        }else {
			String studentCode = request.getParameter("studentCode");
			String studentName = request.getParameter("studentName");
			String birthday = request.getParameter("birthday");
			String address = request.getParameter("address");
			Double score =  Double.valueOf(request.getParameter("score"));
		    StudentInfo newStudent = new StudentInfo( new Student(studentName, studentCode), address, score, birthday);
		    //Create student
		    studentInfoRepo.save(newStudent);
		    // Add message to model to print notify
		    model.addAttribute("msgSuccess", "Add student success!");
		    return "NewStudent";
        }

	}
	
	@RequestMapping(value = "/infoStudent/id/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") String id,Model model){
	    //Find student by info_id to edit
		Student student = studentRepo.findBystudentId(Long.valueOf(id));
		model.addAttribute("Student", student);
	    return "EditStudent"; 
	}
	/*
	 * Find student by info_id
	 * then get info Student then update into StudentInfo and student 
	 */
	@RequestMapping(value = "/updateStudent/id/{id}", method = RequestMethod.POST)
	public String updateStudent(@PathVariable("id") String id, WebRequest request, 
			Model model){
		
	    //Find student by info_id to edit
		Student student = studentRepo.findBystudentId(Long.valueOf(id));
		Long infoId = student.getStudentInfoBasic().getInfoId();
		String studentCode = request.getParameter("studentCode");
		String studentName = request.getParameter("studentName");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		Double score =  Double.valueOf(request.getParameter("score"));
		Student newStudent = new Student(Long.valueOf(id), studentName, studentCode);
		StudentInfo newStudentInfo = new StudentInfo(infoId, newStudent, address, score, birthday);
		// Update student
		studentInfoRepo.save(newStudentInfo);
		model.addAttribute("msgSuccess", "Update success!");
	    return "redirect:/infoStudent/id/"+id; 
	}
	
	/*
	 * Delete StudentInfo by InfoId 
	 * then delete Student by Student_id get in StudentInfo 
	 */
	@RequestMapping(value = "/deleteStudent/id/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") String id,Model model){
		StudentInfo studentInfo = studentInfoRepo.findByinfoId(Long.valueOf(id));
		studentInfoRepo.delete(studentInfo);
		model.addAttribute("Student", "Student have been delete!");
	    return "redirect:/listStudent"; 
	}
}
