package com.springboothello.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.springboothello.entity.User;
import com.springboothello.form.RegisterForm;
import com.springboothello.service.UserService;

/**
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create UserController class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Controller
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	/**
	 * Go to page register and create new RegisterForm
	 * @param model
	 * @return Page register
	 */
	@GetMapping("/register")
	public String register(Model model) {
		// Create log 
		if (logger.isDebugEnabled()) {
			logger.debug("===== Go to page Create new user =====");
		}
		model.addAttribute("registerForm", new RegisterForm());
		return "Register";
	}

	/**
	 * Get value from RegisterForm and check valid then save user
	 * @param registerForm
	 * @param result
	 * @param model
	 * @param request
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String registerUser(@Valid RegisterForm registerForm, BindingResult result, Model model,
			HttpServletRequest request) throws Exception{
		// Check error form
		if (result.hasErrors()) {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Have error when create new user =====");
			}
			return "Register";
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Create new user : " + registerForm.getUserName() + " =====");
			}
			String username = registerForm.getUserName();
			String password = registerForm.getPassword();
			String passwordConfirm = registerForm.getPasswordConfirm();
			User checkuser = userService.findByusername(username);
			// Check user name exist in database
			if (checkuser != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("===== User : " + registerForm.getUserName() + " is exist =====");
				}
				model.addAttribute("msgError", "Account name is exist!");
				return "Register";
			} else {
				// Check Password and Confirm Password
				if (password.equals(passwordConfirm)) {
					PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
					String hashedPassword = passwordEncoder.encode(password);
					if (logger.isDebugEnabled()) {
						logger.debug("Create new user : " + registerForm.getUserName() + " success =====");
					}
					System.out.println(hashedPassword);
					User user = new User(username, hashedPassword, "ROLE_MEMBER");

					userService.save(user);

					model.addAttribute("msgSuccess", "Create User " + username + " success!");
					return "Register";
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("Create new user " + registerForm.getUserName()
								+ " fail: Confirm password does not match =====");
					}
					model.addAttribute("Error", "Confirm password does not match!");
					return "Register";
				}
			}
		}

	}

}
