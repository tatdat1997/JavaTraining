package com.springboothello.form;

import javax.validation.constraints.NotEmpty;

public class SearchNomalForm {
	
	@NotEmpty(message = "Student name must be not null for search")
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
}
