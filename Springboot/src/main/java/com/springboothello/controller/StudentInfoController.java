package com.springboothello.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.springboothello.entity.StudentInfo;
import com.springboothello.repositories.StudentInfoRepo;

@Controller
public class StudentInfoController {
	@Autowired
	private StudentInfoRepo studentInfoRepo;

	@RequestMapping(value = "/studentinfo", method = RequestMethod.GET)
	public String studentInfoAll(Model model){

	    List<StudentInfo> studentInfo = studentInfoRepo.findAll();
	    // Đưa thông tin vào Model
        model.addAttribute("studentInfoList", studentInfo);
	    return "ListStudent";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public RedirectView editStudentInfo(RedirectAttributes redirectAttributes, Model model){
	
		return new RedirectView("studentinfo");
	}
	@GetMapping("/newStudent")
	public String newStudent(HttpSession http) {
		return "NewStudent";
	}
	
	@GetMapping(value = "/studentInfoRepo/{username}")
	public String userByStudentID(@PathVariable Integer studentID){

		StudentInfo user = studentInfoRepo.findByStudentId(studentID);

	    return ""+user+" ";
	}
}

