package com.springboothello.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboothello.entity.User;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create UserService interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Component
public interface UserService {

	User findByusername(String username);

	List<User> findAll();

	public void save(User user);
}
