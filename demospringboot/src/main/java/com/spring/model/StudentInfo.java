package com.spring.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentInfo {
	@Id
	@GeneratedValue
	@Column(name = "info_id", unique = true)
	private Long infoId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "average_score")
	private Double averageScore;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
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

	public void setDateOfBirth(String dateOfBirth) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth);
			this.dateOfBirth = birthDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StudentInfo() {
		super();
	}

	public StudentInfo(Student student, String address, Double averageScore, String dateOfBirth) {
		super();
		this.student = student;
		this.address = address;
		this.averageScore = averageScore;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth);
			this.dateOfBirth = birthDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StudentInfo(Long infoId, Student student, String address, Double averageScore, String dateOfBirth) {
		super();
		this.infoId = infoId;
		this.student = student;
		this.address = address;
		this.averageScore = averageScore;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth);
			this.dateOfBirth = birthDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String print() {
		return this.student.getStudentId() + " | " + this.student.getStudentCode() + " | "
				+ this.student.getStudentName() + " | " + this.infoId + " | " + this.address + " | "
				+ this.averageScore;
	}

}
