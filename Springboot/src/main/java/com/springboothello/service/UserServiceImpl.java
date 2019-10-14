package com.springboothello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboothello.entity.User;
import com.springboothello.repositories.UserRepo;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> findAll() {
	    return userRepo.findAll();
	}

	@Override
	public User findByusername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByusername(username);
	}
}
