package com.springboothello.service;

import java.util.List;


import com.springboothello.entity.User;

public interface UserService {

	User findByusername(String username);

	
	List<User> findAll();
}
