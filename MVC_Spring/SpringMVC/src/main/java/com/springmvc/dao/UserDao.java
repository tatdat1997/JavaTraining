package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.User;

public interface UserDao {
	 void save(User user);
	   List<User> list();
}
