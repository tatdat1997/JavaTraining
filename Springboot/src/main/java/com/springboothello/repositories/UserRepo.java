package com.springboothello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.User;

import java.util.List;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create UserRepo interface
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByusername(String username);

	List<User> findAll();

}
