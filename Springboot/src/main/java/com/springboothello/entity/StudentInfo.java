package com.springboothello.entity;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create StudentInfo class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Entity
public class StudentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long infoId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student studentBasic;

	private String address;

	@Max(value = 10, message = "Score cannot be greater than 10!")
	@Min(value = 1, message = "Score cannot be less than 1")
	private Double averageSore;

	@DateTimeFormat(iso = ISO.DATE)
	private Date dateOfBirth;

	public StudentInfo(Long infoId, Student studentBasic, String address, Double averageSore, String dateOfBirth) {
		super();
		this.infoId = infoId;
		this.studentBasic = studentBasic;
		this.address = address;
		this.averageSore = averageSore;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth);
			this.dateOfBirth = birthDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StudentInfo(Student studentBasic, String address, Double average_sore, String date_of_birth) {
		super();
		this.studentBasic = studentBasic;
		this.address = address;
		this.averageSore = average_sore;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date birthDay = format.parse(date_of_birth);
			this.dateOfBirth = birthDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StudentInfo() {
		super();
	}

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long id) {
		this.infoId = id;
	}

	@JsonBackReference
	public Student getStudent() {
		return studentBasic;
	}

	public void setStudent(Student studentBasic) {
		this.studentBasic = studentBasic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAverageSore() {
		return averageSore;
	}

	public void setAverageSore(Double average_sore) {
		this.averageSore = average_sore;
	}

	public String getDateOfBirth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(this.dateOfBirth);
		return date;
	}

	public String getDateOfBirthFormat() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(this.dateOfBirth);
		return date;
	}

	public void setDateOfBirth(String date_of_birth) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date birthDay = format.parse(date_of_birth);
			this.dateOfBirth = birthDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String print() {
		return this.studentBasic.getStudentId() + " | " + this.studentBasic.getStudentCode() + " | "
				+ this.studentBasic.getStudentName() + " | " + this.infoId + " | " + this.address + " | "
				+ this.averageSore;
	}
}
