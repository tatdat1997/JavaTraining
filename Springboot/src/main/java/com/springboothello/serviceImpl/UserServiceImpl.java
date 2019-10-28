package com.springboothello.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboothello.entity.User;
import com.springboothello.repositories.UserRepository;
import com.springboothello.service.UserService;

import java.util.List;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create UserServiceImpl class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByusername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByusername(username);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	
	
}
