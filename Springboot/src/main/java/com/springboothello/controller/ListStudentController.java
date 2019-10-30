package com.springboothello.controller;

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
		if (logger.isDebugEnabled()) {
			logger.debug("===== Search Ajax Form =====");
		}
		return "SearchAjax";
	}
	/*
	 * Go to page load all student.
	 */
	@RequestMapping(value = "listStudent/page/{pageNumber}", method = RequestMethod.GET)
	public String inDexPage(Model model,@PathVariable("pageNumber") int pageNumber ) {
		// Find all student
		long sizeList = studentService.count();
		int size;
		if(sizeList%10 == 0) {
			size = (int)sizeList/10;
		}else
		{
			size = (int)(sizeList/10) + 1;
		}
		model.addAttribute("total",sizeList);
		model.addAttribute("sizeList",size);
		Pageable pageable;
		if(pageNumber >0) {
			pageable = PageRequest.of(pageNumber-1, 10);
		}else {
			pageable = PageRequest.of(0, 10);
		}
		if(pageNumber > size) {
			pageable = PageRequest.of(size-1, 10);
		}
		List<Student> listStudent = studentService.findAllStudent(pageable);
		model.addAttribute("listStudent", listStudent);
		model.addAttribute("page", pageNumber);
        return "ListStudent";

    }

}
