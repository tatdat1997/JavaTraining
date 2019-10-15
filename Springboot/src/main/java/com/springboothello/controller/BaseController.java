package com.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Index";
	}

//	@RequestMapping("/register")
//	public String register() {
//		return "Register";
//	}
	@RequestMapping("/editStudentInfo")
	public String editStudentInfo() {
		return "editStudentInfo";
	}
	
}
