package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("login")
	public String login(Model model) {
		model.addAttribute("greeting", "Hello Spring MVC 2");
		return "Login";
	}
	@RequestMapping("/editUsers")
	public String editUsers() {
		return "editUsers";
	}
	@RequestMapping("/user")
	  public String userInfo(Model model,
	          @RequestParam(value = "name", defaultValue = "Guest") String name) {
	 
	      model.addAttribute("name", name);
	 
	      if ("admin".equals(name)) {
	          model.addAttribute("email", "admin@example.com");
	      } else {
	          model.addAttribute("email", "Not set");
	      }
	      return "userInfo";
	  }
}
