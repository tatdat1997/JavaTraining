package com.spring.repositories;
import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable>{
	
	User findByusername(String username);
}
