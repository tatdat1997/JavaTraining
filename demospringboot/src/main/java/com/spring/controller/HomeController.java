package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	/*
	 * Go to login page
	 */
	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("val", "Welcome back.");
		return "Index";
	}
	@RequestMapping("/login")
	public String Login() {
		return "Login";
	}
}
