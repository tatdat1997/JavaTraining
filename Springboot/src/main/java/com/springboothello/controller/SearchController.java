package com.springboothello.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboothello.entity.AjaxResponseBody;
import com.springboothello.entity.Student;
import com.springboothello.form.SearchForm;
import com.springboothello.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create SearchController class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@RestController
public class SearchController {

	private static final Logger logger = LogManager.getLogger(SearchController.class);

	StudentService studentServiceImpl;

	@Autowired
	public void setStudentServiceImpl(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

	/*
	 * Get studentName from searchAjax form and find student by studentName Return
	 * result to searchAjax form
	 */
	@PostMapping("/api/search")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchForm search, Errors errors) {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Search with Ajax =====");
		}

		AjaxResponseBody result = new AjaxResponseBody();

		// If error, just return a 400 bad request, along with the error message
		if (errors.hasErrors()) {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Have error when search with Ajax= ====");
			}
			result.setMsg(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);

		}
		if (logger.isDebugEnabled()) {
			logger.debug("===== Find student: " + search.getStudentName() + " =====");
		}
		List<Student> student = studentServiceImpl.findBystudentName(search.getStudentName());
		// If list student is empty return message not found
		if (student.isEmpty()) {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Not found student: " + search.getStudentName() + " =====");
			}
			result.setMsg("Student not found!");
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Find student: " + search.getStudentName() + " success. =====");
			}
			// List not empty return message success
			result.setMsg("success");
		}
		// Set result is list list student and return
		result.setResult(student);

		return ResponseEntity.ok(result);

	}

}
