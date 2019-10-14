package com.springboothello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothello.entity.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer>{
	User findByusername(String username);

	List<User> findAll();

}
