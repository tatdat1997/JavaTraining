package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	/*
	 * Go to login page
	 */
	@RequestMapping("/")
	public String index() {
		return "Index";
	}
}
