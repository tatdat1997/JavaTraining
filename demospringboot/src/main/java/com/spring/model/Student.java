package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "student_code")
	private String studentCode;

	@OneToOne(mappedBy = "student")
	private StudentInfo studentInfo;
	
	@JsonManagedReference
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public Student(String studentName, String studentCode, StudentInfo studentInfo) {
		super();
		this.studentName = studentName;
		this.studentCode = studentCode;
		this.studentInfo = studentInfo;
	}

	public Student() {
		super();
	}
	public String PrintInfo() {
		return this.getStudentCode() + " | " + this.studentName + " | " + this.getStudentInfo().getAddress()
				+ " | " + this.getStudentInfo().getDateOfBirthFormat();
	}
	
}
