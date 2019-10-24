package com.springboothello.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboothello.entity.Student;
import com.springboothello.form.SearchForm;
import com.springboothello.service.StudentService;

@Controller
public class ListStudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/search")
	public String index() {
		return "SearchAjax";
	}

	/*
	 * Page print list student
	 */
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public String listStudent(Model model) {
		List<Student> listStudent = studentService.findAllByAsc();
		// Add listStudent in Model to transmission to the interface
		model.addAttribute("listStudent", listStudent);
		model.addAttribute("searchForm", new SearchForm());
		return "ListStudent";
	}

	/*
	 * Find student by name
	 */
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String searchStudent(@Valid SearchForm searchForm, BindingResult result, Model model) {

		// Find student by Parameter
		if (result.hasErrors()) {
			return "ListStudent";
		} else {
			String studentName = searchForm.getStudentName();
			if (!studentName.isEmpty()) {
				List<Student> studentByName = studentService.findBystudentName(studentName);
				if (!studentByName.isEmpty()) {
					model.addAttribute("listStudent", studentByName);
					return "ListStudent";
				} else {
					model.addAttribute("notFound", "Student not found!");
					return "ListStudent";
				}
			}
			return "ListStudent";
		}
	}

}
