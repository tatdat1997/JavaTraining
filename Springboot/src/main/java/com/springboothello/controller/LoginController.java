package com.springboothello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboothello.entity.User;
import com.springboothello.service.UserService;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create LoginController class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */
@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	/*
	 * Go to login page
	 */
	@RequestMapping("/")
	public String index() {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Wellcome =====");
		}
		return "Index";
	}

	/*
	 * Go to login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logIn(Model model) {
		logger.debug("===== Login Form!! =====");
		return "Login";
	}

	/*
	 * Get values from page login and check in database Create session
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public String logInPost2(Model model, HttpServletRequest request, HttpSession session) {
		String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		User checkUser = userService.findByusername(currentUserName);
		// Check user in database to login and create session if null return login fail
		if (checkUser != null) {
			session.setAttribute("user", checkUser.toMap());
			logger.debug("===== Login with username: " + currentUserName + " =====");
			return "redirect:/search";
		} else {
			logger.debug("===== Login fail!! =====");
			String messString = "Accout or Password is incorect!!";
			model.addAttribute("msgError", messString);
			return "Login";
		}

	}

}
