package com.springmvc.service;

import java.util.List;

import com.springmvc.model.User;

public interface UserService {
	   void save(User user);
	 
	   List<User> list();
	}
