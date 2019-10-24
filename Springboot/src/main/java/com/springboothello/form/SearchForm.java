package com.springboothello.form;

import javax.validation.constraints.NotBlank;

public class SearchForm {

    @NotBlank(message = "Student name must be not null for search!")
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}