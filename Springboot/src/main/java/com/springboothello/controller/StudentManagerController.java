package com.springboothello.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboothello.entity.Student;
import com.springboothello.entity.StudentInfo;
import com.springboothello.form.StudentForm;
import com.springboothello.service.StudentInfoService;
import com.springboothello.service.StudentService;

//
///*
// * Copyright (C) 2015 by GMO Runsystem Company
// *
// * Create StudentManagerController class
// *
// * @version 1.0
// *
// * @author DatNT
// *
// */
//
@Controller
public class StudentManagerController {

	private static final Logger logger = LogManager.getLogger(StudentManagerController.class);

	@Autowired
	private StudentInfoService studentInfoService;

	@Autowired
	private StudentService studentService;
	
	/**
	 *  Get view and create Form Student 
	 * @param model
	 * @param http
	 * @return View NewStudent
	 */
	@RequestMapping(value = "/newStudent")
	public String newFormStudent(Model model, HttpSession http) {
		// Create log
		HashMap<?, ?> A = (HashMap<?, ?>) http.getAttribute("user");
		if (logger.isDebugEnabled()) {
			logger.debug("===== User " + A.get("username") + ": Go to page Create new student =====");
		}
		model.addAttribute("studentForm", new StudentForm());
		return "NewStudent";
	}
	/**
	 * 		Save student, get value form student form and check valid, 
	 * 	return message when create success or have error
	 * @param studentForm
	 * @param result
	 * @param model
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String newStudent(@Valid StudentForm studentForm, BindingResult result, Model model, HttpSession http)
			throws Exception {
		HashMap<?, ?> user = (HashMap<?, ?>) http.getAttribute("user");
		if (logger.isDebugEnabled()) {
			logger.debug("===== Create new student =====");
		}
		// If have error return error
		if (result.hasErrors()) {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Have error when create new student =====");
			}
			return "NewStudent";
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("===== User " + user.get("username") + ": Create new student :"
						+ studentForm.getStudentCode() + " =====");
			}
			String studentCode = studentForm.getStudentCode();
			String studentName = studentForm.getStudentName();
			String birthday = studentForm.getDateOfBirth();
			String address = studentForm.getAddress();
			Double score = Double.valueOf(studentForm.getScore());
			StudentInfo newStudent = new StudentInfo(new Student(studentName, studentCode), address, score, birthday);
			// Create student
			try {
				studentInfoService.saveStudent(newStudent);
			} catch (Exception e) {
				// TODO: handle exception
				if (logger.isDebugEnabled()) {
					logger.debug("===== Have error when create student: " + studentForm.getStudentCode() + " =====");
				}
				return "/error500";
			} finally {

			}
			// Add message to model to print notify
			model.addAttribute("msgSuccess", "Add student success!");
			return "NewStudent";
		}

	}
	/**
	 * Show get student by student_id and show info for user edit.
	 * @param id
	 * @param model
	 * @return info student
	 */
	@RequestMapping(value = "/infoStudent/id/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") String id, Model model) {
		// Find student by info_id to edit
		Student student = studentService.findBystudentId(Long.valueOf(id));
		model.addAttribute("Student", student);
		StudentForm newStudent = new StudentForm();
		newStudent.setStudentCode(student.getStudentCode());
		newStudent.setStudentName(student.getStudentName());
		newStudent.setAddress(student.getStudentInfoBasic().getAddress());

		newStudent.setScore(String.valueOf(student.getStudentInfoBasic().getAverageSore()));
		newStudent.setDateOfBirth(student.getStudentInfoBasic().getDateOfBirth());
		model.addAttribute("studentForm", newStudent);
		return "EditStudent";
	}

	/*
	 * Find student by info_id then get info Student then update into StudentInfo
	 * and student
	 */
	/**
	 * Get info student and update info student by student_id
	 * @param id
	 * @param studentForm
	 * @param result
	 * @param model
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStudent/id/{id}", method = RequestMethod.POST)
	public String updateStudent(@PathVariable("id") String id, @Valid StudentForm studentForm, BindingResult result,
			Model model, HttpSession http) throws Exception {
		HashMap<?, ?> user = (HashMap<?, ?>) http.getAttribute("user");
		if (logger.isDebugEnabled()) {
			logger.debug("===== User " + user.get("username") + ": Update student have Student_Id: " + id + " =====");
		}
		// Find student by info_id to edit
		Student student = studentService.findBystudentId(Long.valueOf(id));
		Long InfoID = student.getStudentInfoBasic().getInfoId();
		String address = studentForm.getAddress();
		Double score = Double.valueOf(studentForm.getScore());
		String day = studentForm.getDateOfBirth();
		String student_code = student.getStudentCode();
		Long student_id = student.getStudentId();
		String student_name = studentForm.getStudentName();
		// create new info for student need update
		StudentInfo newStudentInfo = new StudentInfo(InfoID, new Student(student_id, student_name, student_code),
				address, score, day);
		// Update student
		studentInfoService.saveStudent(newStudentInfo);
		model.addAttribute("msgSuccess", "Update success!");
		return "redirect:/infoStudent/id/" + id;
	}

	/**
	 * Delete StudentInfo by InfoId then delete Student by Student_id get in StudentInfo 
	 * @param id
	 * @param model
	 * @param http
	 * @return
	 */
	@RequestMapping(value = "/deleteStudent/id/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") String id, Model model, HttpSession http) {
		HashMap<?, ?> user = (HashMap<?, ?>) http.getAttribute("user");
		if (logger.isDebugEnabled()) {
			logger.debug("===== User " + user.get("username") + " Delete student have Info_Id: " + id + " =====");
		}

		StudentInfo studentInfo = studentInfoService.findByinfoId(Long.valueOf(id));

		studentInfoService.delete(studentInfo);

		return "redirect:/search";
	}

}
