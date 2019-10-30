package com.springboothello.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboothello.entity.AjaxResponseBody;
import com.springboothello.entity.Student;
import com.springboothello.form.SearchForm;
import com.springboothello.service.StudentService;

import javax.servlet.http.HttpSession;
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

	StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	/*
	 * Get studentName from searchAjax form and find student by studentName Return
	 * result to searchAjax form
	 */
	@PostMapping("/api/search")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchForm search, 
			Errors errors, HttpSession http) {
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
		Pageable pageable = PageRequest.of(0, 10);
		List<Student> student = studentService.findByStudentName(search.getStudentName(), pageable);
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
			http.setAttribute("search", search.getStudentName());
			int totalPage;
			if (studentService.countByName(search.getStudentName())/10 ==0) {
				totalPage = (int) (studentService.countByName(search.getStudentName())/10);
			} else {
				totalPage = (int) (studentService.countByName(search.getStudentName())/10) + 1;
			}
			http.setAttribute("total", totalPage);
			result.setMsg("success");
			result.setTotalPage(totalPage);
			result.setTotalStudent(studentService.countByName(search.getStudentName()));
		}
		// Set result is list list student and return
		result.setResult(student);
		
		return ResponseEntity.ok(result);

	}
	
	@GetMapping("/api/search/page/{page}")
	public ResponseEntity<?> getSearchAjax(@PathVariable("page") int page, HttpSession http) {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Search with Ajax =====");
		}

		AjaxResponseBody result = new AjaxResponseBody();
		http.setAttribute("page", page);
		
		String search = (String) http.getAttribute("search");
		int totalPage;
		if (studentService.countByName(search)/10 ==0) {
			totalPage = (int) (studentService.countByName(search)/10);
		} else {
			totalPage = (int) (studentService.countByName(search)/10) + 1;
		}
		Pageable pageable = PageRequest.of(page, 10);
		List<Student> student = studentService.findByStudentName(search, pageable);
		// If list student is empty return message not found
		if (student.isEmpty()) {

			result.setMsg("Student not found!");
		} else {

			// List not empty return message success
			result.setMsg("success");
			result.setTotalPage(totalPage);
			result.setTotalStudent(studentService.countByName(search));
		}
		// Set result is list list student and return
		result.setResult(student);

		return ResponseEntity.ok(result);

	}
}
