package com.springboothello.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboothello.entity.User;

import java.io.Serializable;
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
@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {
	User findByusername(String username);

	List<User> findAll();
	
}
