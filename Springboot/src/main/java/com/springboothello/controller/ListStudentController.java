package com.springboothello.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create ListStudentController class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Controller
public class ListStudentController {

	private static final Logger logger = LogManager.getLogger(ListStudentController.class);

	@Autowired
	StudentService studentService;

	/*
	 * Go to page search student by Ajax
	 */
	@GetMapping("/search")
	public String index() {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Search Ajax Form =====");
		}
		return "SearchAjax";
	}

	/*
	 * Go to page print list student
	 */
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public String listStudent(Model model) {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Hello List Student =====");
		}
		List<Student> listStudent = studentService.findAllByAsc();
		// Add listStudent in Model to transmission to the interface
		model.addAttribute("listStudent", listStudent);
		// Create new SearchForm
		model.addAttribute("searchForm", new SearchForm());
		return "ListStudent";
	}

	/*
	 * Find student by name, get name from form and find
	 */
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String searchStudent(@Valid SearchForm searchForm, BindingResult result, Model model) {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Search student =====");
		}
		// Check errors
		if (result.hasErrors()) {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Have error when search student =====");
			}
			return "ListStudent";
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Search student with student name: " + searchForm.getStudentName() + "=====");
			}
			String studentName = searchForm.getStudentName();
			// Check empty studentName get from form.
			if (!studentName.isEmpty()) {
				// Find student by studentName
				List<Student> studentByName = studentService.findBystudentName(studentName);
				// Check empty list student has found
				if (!studentByName.isEmpty()) {
					if (logger.isDebugEnabled()) {
						logger.debug("===== Search student success =====");
					}
					// Return list student
					model.addAttribute("listStudent", studentByName);
					return "ListStudent";
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("===== Search student fail =====");
					}
					// Return message notify
					model.addAttribute("notFound", "Student not found!");
					return "ListStudent";
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("===== Search student fail =====");
			}
			return "ListStudent";
		}
	}

}
