package com.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;

public class UserServiceImpl implements UserService{
	@Autowired
	   private UserDao userDao;
	 
	   @Transactional
	   public void save(User user) {
	      userDao.save(user);
	   }
	 
	   @Transactional
	   public List<User> list() {
	      return userDao.list();
	   }
}
