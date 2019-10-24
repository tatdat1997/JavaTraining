package com.springboothello.service;

import java.util.List;

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

public interface UserService {

	User findByusername(String username);

	List<User> findAll();
}
