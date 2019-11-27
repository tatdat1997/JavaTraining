package com.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.form.LoginForm;
import com.spring.model.User;
import com.spring.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checklogin")
	public ResponseEntity<?> Checklogin(@Valid @RequestBody LoginForm form, HttpSession http) {
		String user = form.getUsername();
		String pass = form.getPassword();
		User check = userService.findByusername(user);
		HashMap<String, String> result = new HashMap<>();
		if(check != null) {
			if(check.getPassword().equals(pass)) {
				result.put("status", "OK");
				http.setAttribute("user", check);
			}else {
				result.put("status", "Fail");
			}
		}
		return ResponseEntity.ok(result);
	}
	@RequestMapping("/logout")
	public ModelAndView Logout(HttpSession http) {
		http.removeAttribute("user");
		ModelAndView mav = new ModelAndView("Index");
		return mav;
		
	}
	
}
