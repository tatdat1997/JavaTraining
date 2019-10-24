package com.springboothello.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboothello.entity.AjaxResponseBody;
import com.springboothello.entity.Student;
import com.springboothello.form.SearchForm;
import com.springboothello.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

	
    StudentService studentServiceImpl;
        

    @Autowired
    public void setStudentServiceImpl(StudentService studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchForm search, Errors errors) {

 
        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
            		.collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
            

        }
        List<Student> student = studentServiceImpl.findBystudentName(search.getStudentName());
        if (student.isEmpty()) {
            result.setMsg("Student not found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(student);

        return ResponseEntity.ok(result);
        
    }

	

}
