package com.springboothello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
    @Column(name="student_id", unique = true)
    private Integer studentId;
	
	@Column(name = "student_name", nullable = false, length = 20)
	private String studentName;
	
	
	@Column(name = "student_code", nullable = false, length = 10)
	private String studentCode;


	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
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


	public Student(Integer studentId, String studentName, String studentCode) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCode = studentCode;
	}


	public Student(String studentName, String studentCode) {
		super();
		this.studentName = studentName;
		this.studentCode = studentCode;
	}


	public Student() {
		super();
	}
	
	
}
