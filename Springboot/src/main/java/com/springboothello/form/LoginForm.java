package com.springboothello.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create LoginForm class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public class LoginForm {

	@NotEmpty(message = "User Name must be not null!")
	@Length(min = 3, max = 15, message = "User Name must be more than 3 and less than 15")
	private String userName;

	@NotEmpty(message = "Password must be not null!")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
