package com.springboothello.form;

import javax.validation.constraints.NotEmpty;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create RegisterForm class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public class RegisterForm {

	@NotEmpty(message = "User Name must be not null!")
	private String userName;

	@NotEmpty(message = "Password must be not null!")
	private String password;

	@NotEmpty(message = "Password Confirm must be not null!")
	private String passwordConfirm;

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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

}
