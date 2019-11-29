package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring.form.StudentForm;
import com.spring.model.Student;
import com.spring.model.StudentInfo;
import com.spring.service.StudentInfoService;
import com.spring.service.StudentService;

@Controller
public class StudentController {
	
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	@Autowired
	StudentInfoService studentInfoService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String Student(Model model) {
		List<StudentInfo> studentLs = studentInfoService.findAll();
		model.addAttribute("ListStudent", studentLs);
		return "Liststudent";
	}
	
	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public String newStudent(Model model) {
		model.addAttribute("studentForm", new StudentForm());
		return "NewStudent";
	}
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(Model model, @Valid StudentForm studentForm, BindingResult result) {
		String address = studentForm.getAddress();
		Double score = Double.valueOf(studentForm.getScore());
		String day = studentForm.getDateOfBirth();
		String student_code = studentForm.getStudentCode();
		String student_name = studentForm.getStudentName();
		StudentInfo newStudentInfo = new StudentInfo(new Student(student_name, student_code), address, score, day);
		studentInfoService.saveStudentInfo(newStudentInfo);
		logger.debug("===== Create new student: "+student_code+" =====");
		return "NewStudent";
	}
	@RequestMapping(value = "/infoStudent/id/{id}", method = RequestMethod.GET)
	public String infoStudent(@PathVariable("id") int id, Model model) {
		Student student = studentService.findByStudentId(id);
		model.addAttribute("Student", student);
		StudentForm newStudent = new StudentForm();
		newStudent.setStudentCode(student.getStudentCode());
		newStudent.setStudentName(student.getStudentName());
		newStudent.setAddress(student.getStudentInfo().getAddress());
		newStudent.setScore(String.valueOf(student.getStudentInfo().getAverageScore()));
		newStudent.setDateOfBirth(student.getStudentInfo().getDateOfBirth());
		model.addAttribute("studentForm", newStudent);
		return "InfoStudent";
	}
	@RequestMapping(value = "/updateStudent/id/{id}", method = RequestMethod.POST)
	public String updateStudent(@PathVariable("id") int id, Model model, @Valid StudentForm studentForm, BindingResult result) {
		Student student = studentService.findByStudentId(id);
		Long InfoID = student.getStudentInfo().getInfoId();
		String address = studentForm.getAddress();
		Double score = Double.valueOf(studentForm.getScore());
		String day = studentForm.getDateOfBirth();
		String student_code = student.getStudentCode();
		Long student_id = student.getStudentId();
		String student_name = studentForm.getStudentName();
		StudentInfo newStudentInfo = new StudentInfo(InfoID, new Student(student_id, student_name, student_code), address, score, day);
		studentInfoService.saveStudentInfo(newStudentInfo);
		return "redirect:/student";
	}
	@RequestMapping(value = "/deleteStudent/id/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long id) {
		studentInfoService.deleteStudentByInfoID(id);
		return "redirect:/student";
	}
}
