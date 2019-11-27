package com.spring.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repositories.UserRepository;
import com.spring.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override	
	public User findByusername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByusername(username);
	}
	
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

}
