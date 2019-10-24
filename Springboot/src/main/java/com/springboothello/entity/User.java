package com.springboothello.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create User class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "user_id", unique = true)
	private Long user_id;

	@Column(name = "user_name", nullable = false, length = 20, unique = true)
	@NotNull(message = "User name cannot be null")
	@Size(min = 5, max = 20, message = "User name must be 5-20 character")
	private String username;

	@Column(name = "password", nullable = true, length = 15)
	@NotNull(message = "Password cannot be null")
	@Size(min = 5, max = 20, message = "Password must be 5-20 character")
	private String password;

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User{" + "user_id='" + user_id + "user_name='" + username + '}' + "" + super.toString();
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return username;
	}

	public void setUser_name(String user_name) {
		this.username = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Long user_id, String user_name, String password) {
		super();
		this.user_id = user_id;
		this.username = user_name;
		this.password = password;
	}

	public User(String user_name, String password) {
		super();
		this.username = user_name;
		this.password = password;
	}

}