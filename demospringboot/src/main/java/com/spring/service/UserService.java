package com.spring.service;

import org.springframework.stereotype.Component;

import com.spring.model.User;

@Component
public interface UserService {
	User findByusername(String username);
	
	public void save(User user);
}
