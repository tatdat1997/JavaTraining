package com.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.form.RegisterForm;
import com.spring.model.User;
import com.spring.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String Register(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		return "Register";
	}
	
	@RequestMapping(value = "/checkregister", method = RequestMethod.POST)
	public String CheckRegister(@Valid RegisterForm registerForm, BindingResult result, Model model) {
		String username = registerForm.getUsername();
		String password = registerForm.getPassword();
		String passwordConfirm = registerForm.getCfmpassword();
		if (result.hasErrors()) {
			return "Register";
		} else {
			User checkuser = userService.findByusername(username);
			if (checkuser == null) {
				if (password.equals(passwordConfirm)) {
					userService.save(new User(username,password,"USER"));
				}else {
					model.addAttribute("msgError", "Password is not match!");
					return "Register";
				}
			}else {
				model.addAttribute("msgError", "Account name is exist!");
				return "Register";
			}
		}
		return "Login";
	}
}
