package com.springboothello.entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//import org.hibernate.validator.constraints;

@Entity
@Table(name = "student")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
	
	@NotEmpty(message = "Student name must be not null!")
	@Column(name = "student_name")
	private String studentName;
	

	@Column(name = "student_code")
	@NotEmpty(message = "Student name must be not null!")
	private String studentCode;
	
	@OneToOne(mappedBy = "studentBasic")
    private StudentInfo studentInfoBasic;

	public Student() {
		super();
	}

	public Student( String student_name, String student_code) {
		super();
		studentName = student_name;
		studentCode = student_code;
	}

	public Student(Long studentId, String studentName, String studentCode) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCode = studentCode;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long student_id) {
		studentId = student_id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String student_name) {
		studentName = student_name;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudenCode(String student_code) {
		studentCode = student_code;
	}

	public StudentInfo getStudentInfoBasic() {
		return studentInfoBasic;
	}

	public void setStudentInfoBasic(StudentInfo studentInfoBasic) {
		this.studentInfoBasic = studentInfoBasic;
	}
	
	public String PrintInfo() {
		return this.getStudentCode() + " | " + this.studentName + " | " + this.getStudentInfoBasic().getAddress() 
				+ " | " + this.getStudentInfoBasic().getDateOfBirthFormat();
	}
	
}
