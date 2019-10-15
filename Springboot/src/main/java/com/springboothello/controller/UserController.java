package com.springboothello.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.springboothello.entity.User;
import com.springboothello.repositories.UserRepo;

@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userAll(){

	    List<User> users = userRepo.findAll();

	    return ""+users+" ";
	}
	@GetMapping(value = "/user/{username}")
	public String userByusername(@PathVariable String username){

	    User user = userRepo.findByusername(username);

	    return ""+user+" ";
	}
	@GetMapping("/register")
	public String showForm(HttpSession http) {
		return "Register";
	}
//	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
//	public RedirectView  registerUser(WebRequest request,
//			RedirectAttributes redirectAttributes, HttpSession http,
//			@Valid User userValid, BindingResult bindingResult, Model model) {
//		String username = request.getParameter("UserName");
//		String password = request.getParameter("password");
//		String passwordConf = request.getParameter("passwordConf");
//		http.removeAttribute("Error");
//		if(userRepo.findByusername(username) == null) {
//			if(password.equals(passwordConf)) {
//				
//				User user = new User(username, password);
//				userRepo.save(user);
//				
//				model.addAttribute("msgSuccess", "Create User "+ username +" success!");
//				http.removeAttribute("Error");
//				return new RedirectView("register");
//			}
//			http.removeAttribute("msgSuccess");
//			model.addAttribute("Error", "Confirm password does not match!");
//			return new RedirectView("register");
//		}else {
//			http.removeAttribute("msgSuccess");
//			model.addAttribute("Error", "User name already exists!");
//			return new RedirectView("register");
//		}
//    }
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String  registerUser(WebRequest request,
			RedirectAttributes redirect,
			@Valid @ModelAttribute(value="userValid") User userValid, BindingResult bindingResult, Model model) {
		String username = request.getParameter("UserName");
		String password = request.getParameter("password");
		String passwordConf = request.getParameter("passwordConf");
		if(userRepo.findByusername(username) == null) {
			if(password.equals(passwordConf)) {			
				User user = new User(username, password);
				userRepo.save(user);	
				model.addAttribute("msgSuccess", "Create User "+ username +" success!");
				return "register";
			}
			model.addAttribute("Error", "Confirm password does not match!");
			return"register";
		}else {
			model.addAttribute("msgError", "User name already exists!");
			return "register";
		}
    }
}
