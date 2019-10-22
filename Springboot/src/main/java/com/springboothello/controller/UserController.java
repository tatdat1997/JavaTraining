package com.springboothello.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.springboothello.entity.User;
import com.springboothello.form.RegisterForm;
import com.springboothello.repositories.UserRepo;

@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("registerForm", new RegisterForm());
		return "Register";
	}
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String  registerUser(@Valid RegisterForm registerForm, BindingResult result,
			Model model, HttpServletRequest request) {
		
		if(result.hasErrors()) {
            return "Register";
        }else {
        	String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String passwordConfirm = request.getParameter("passwordConfirm");
        	User checkuser = userRepo.findByusername(username);
        	if(checkuser != null) {
        		model.addAttribute("msgError", "Account name is exist!");
        		return "Register";
        	}else {
        		if(password.equals(passwordConfirm)) {	
        			User user = new User(username, password);
        			userRepo.save(user);
        			model.addAttribute("msgSuccess", "Create User "+ username +" success!");
        			return "Register";
        		}else {
        			model.addAttribute("Error", "Confirm password does not match!");
        			return"Register";
        		}
        	}
        }
		
	}

}
