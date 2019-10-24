package com.springboothello.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentForm class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public class StudentForm {

	@NotEmpty(message = "Student code must be not null!")
	private String studentCode;

	@NotEmpty(message = "Student name must be not null!")
	private String studentName;

	private String address;

	@Max(value = 10, message = "Score must be less than 10!")
	@Min(value = 1, message = "Score must be more than 1!")
	@Pattern(regexp = "[0-9]+(.){0,1}[0-9]*", message = "Score must be a number or decimal!")
	private String score;

	@DateTimeFormat(iso = ISO.DATE)
	private String dateOfBirth;

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
