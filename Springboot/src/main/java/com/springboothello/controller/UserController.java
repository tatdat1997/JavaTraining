package com.springboothello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboothello.entity.User;
import com.springboothello.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/user")
	public String userAll(){

	    List<User> users = userService.findAll();

	    return ""+users;
	}

	@GetMapping(value = "/user/{username}")
	public String userByEmail(@PathVariable String username){

	    User user = userService.findByusername(username);

	    return ""+user;
	}
}
