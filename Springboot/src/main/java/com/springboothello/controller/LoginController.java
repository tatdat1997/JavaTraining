package com.springboothello.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springboothello.entity.User;
import com.springboothello.repositories.UserRepo;
@Controller
public class LoginController {

	@Autowired
	private UserRepo userService;
	
	@RequestMapping("/login")
	public String login() {
		return "Login";
	}
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	public String checkLogin(@RequestParam(value="UserName", required=false) String username,
			@RequestParam(value="pwd", required=false) String password, 
			RedirectAttributes redirectAttributes, HttpSession http, Model model){
		if(username.isEmpty() || password.isEmpty()) {
			model.addAttribute("msgError", "Please enter User Name and Password!");
			return "/login";
		}else {
			User user = userService.findByusername(username);
			if(user != null) {
				  if(password.equals(user.getPassword())) {
					  http.setAttribute("user", user);
					  
					  return "redirect:/studentinfo";
				  }else { 
					  model.addAttribute("msgError", "Password is incorrect!");
					  return "/login";
				  }
			  }
			model.addAttribute("msgError", "Account does not exist!");
			return "login";
		}
	}
	@RequestMapping(value = "/logout")
	public RedirectView logout(RedirectAttributes redirectAttributes, HttpSession session) {
		session.removeAttribute("user");
		
		return new RedirectView("login");
	}
	

}
