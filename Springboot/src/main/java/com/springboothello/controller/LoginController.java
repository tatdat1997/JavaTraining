package com.springboothello.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.springboothello.repositories.UserRepo;

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

	@Autowired
	private UserRepo userRepo;
	/*
	 * Show page login
	 */
	@RequestMapping("/")
	public String index() {
		return "Index";
	}
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("loginForm", new LoginForm());
		return "Login";
	}
	/*
	 * Get values from page login and check in database
	 * Create sesseion
	 */
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String checkLogin(@Valid LoginForm loginForm, BindingResult result,
			Model model, HttpServletRequest request, HttpSession http) {
		
		if(result.hasErrors()) {
            return "Login";
        }else {
        	String username = request.getParameter("userName");
			String password = request.getParameter("password");
        	User user = userRepo.findByusername(username);
        	if(user != null) {
        		if(password.equals(user.getPassword())) {
        			http.setAttribute("user", user);
        			return "redirect:/listStudent";
        		}else {
        			model.addAttribute("msgError", "Password is incorrect!");
        			return "Login";
        		}
        	}
        	model.addAttribute("msgError", "Account does not exist!");
        	return "Login";
        }
		
	}
	
	
	
	/*
	 * Logout, remove session and return login page
	 */
	@RequestMapping(value = "/logout")
	public RedirectView logout(RedirectAttributes redirectAttributes, HttpSession session) {
		session.removeAttribute("user");
		
		return new RedirectView("login");
	}
	

}
