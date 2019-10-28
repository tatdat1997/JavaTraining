package com.springboothello.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springboothello.entity.User;
import com.springboothello.form.LoginForm;
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
	@RequestMapping("/login")
	public String login(Model model) {
		// Create log
		if (logger.isDebugEnabled()) {
			logger.debug("===== Hello Login form =====");
		}
		// Create new LoginForm
		model.addAttribute("loginForm", new LoginForm());
		return "Login";
	}

	/*
	 * Get values from page login and check in database Create session
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String checkLogin(@Valid LoginForm loginForm, BindingResult result, Model model, HttpSession http) {
		// Check error for existence
		if (result.hasErrors()) {
			if (logger.isDebugEnabled()) {
				logger.debug("===== Login form has error =====");
			}
			return "Login";
		} else {
			String username = loginForm.getUserName();
			String password = loginForm.getPassword();
			if (logger.isDebugEnabled()) {
				logger.debug("===== Login with User: " + username + " =====");
			}
			User user = userService.findByusername(username);
			// Check account for existence
			if (user != null) {
				// Check if the password is correct
				if (password.equals(user.getPassword())) {
					if (logger.isDebugEnabled()) {
						logger.debug("===== Login success with User: " + username + " =====");
					}
					http.setAttribute("user", user.toMap()); // Set session for user
					return "redirect:/search"; // Go to list student page
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("===== Login fail with User: " + username + " =====");
					}
					// Return message notify error
					model.addAttribute("msgError", "Password is incorrect!");
					return "Login";
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("===== Login fail with User: " + username + " =====");
			}
			// Return message notify error
			model.addAttribute("msgError", "Account does not exist!");
			return "Login";
		}

	}

	/*
	 * Logout, remove session and return login page
	 */
	@RequestMapping(value = "/logout")
	public RedirectView logout(RedirectAttributes redirectAttributes, HttpSession session) {
		if (logger.isDebugEnabled()) {
			logger.debug("===== Logout User: =====");
		}
		// Remove session
		session.removeAttribute("user");
		return new RedirectView("login");
	}

}
