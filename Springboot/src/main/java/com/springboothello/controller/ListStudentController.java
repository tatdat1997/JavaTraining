package com.springboothello.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboothello.entity.Student;
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
	public String index(HttpSession http) {
		// Create log
		if (http.getAttribute("user") != null) {
			HashMap<?, ?> A = (HashMap<?, ?>) http.getAttribute("user");
			logger.debug("===== User " + A.get("username") + ": Search Ajax Form =====");
		}
		return "SearchAjax";
	}

	/*
	 * Go to page load all student. Page show all student and pagination 10
	 * student/page
	 */
	@RequestMapping(value = "listStudent/page/{pageNumber}", method = RequestMethod.GET)
	public String inDexPage(Model model, @PathVariable("pageNumber") int pageNumber, HttpSession http) {
		// Find all student
		long sizeList = studentService.count();
		int size;
		// Find total page. One page have 10 record
		if (sizeList % 10 == 0) {
			size = (int) sizeList / 10;
		} else {
			size = (int) (sizeList / 10) + 1;
		}
		model.addAttribute("total", sizeList);
		model.addAttribute("sizeList", size);
		Pageable pageable;
		// Page number > 0 then begin at Page number -1
		if (pageNumber > 0) {
			pageable = PageRequest.of(pageNumber - 1, 10);
		} else {
			pageable = PageRequest.of(0, 10);
		}
		// Page number > size then begin at size -1
		if (pageNumber >= size) {
			pageable = PageRequest.of(size - 1, 10);
		}
		int count = 0;
		/**
		 * Show in pagination page 1->5 after page 5 show 6->10 ...
		 */
		// If have session count and current page > 10. count = session("count") else count = 1
		if (http.getAttribute("count") != null && pageNumber < 10) {
			count = (int) http.getAttribute("count");
		} else {
			count = 1;
		}
		// If current page > 6 and != 1 and mod 5 =1 count++
		if ((pageNumber % 5 == 1) && (pageNumber != 6) && (pageNumber != 1)) {
			count += 1;
		}
		List<Student> listStudent = studentService.findAllStudent(pageable);
		model.addAttribute("count", count);
		model.addAttribute("listStudent", listStudent);
		model.addAttribute("page", pageNumber);
		return "ListStudent";

	}

}
