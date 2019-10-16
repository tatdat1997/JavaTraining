package com.springboothello.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
    @Column(name="info_id", unique = true)
    private Integer infoId;
	
	@Column(name = "student_id", nullable = false,unique = true)
	private Integer studentId;

    @Column(name = "address", nullable = true, length = 255)
    private String address;
    
    @Column(name = "average_score", nullable = false)
    private Double averageScore;

    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

	

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth); 
			this.dateOfBirth = birthDay;
		}catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public StudentInfo() {
		super();
	}
	public StudentInfo(Integer infoId, Integer studentId, String address, Double averageScore, String dateOfBirth) {
		super();
		this.infoId = infoId;
		this.studentId = studentId;
		this.address = address;
		this.averageScore = averageScore;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth); 
			this.dateOfBirth = birthDay;
		}catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	public StudentInfo(Integer studentId, String address, Double averageScore, String dateOfBirth) {
		super();
		this.studentId = studentId;
		this.address = address;
		this.averageScore = averageScore;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date birthDay = format.parse(dateOfBirth); 
			this.dateOfBirth = birthDay;
		}catch(Exception e) {
	        e.printStackTrace();
	    }
	}
    
    
}
