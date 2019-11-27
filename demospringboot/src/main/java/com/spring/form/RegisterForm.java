package com.spring.form;

import javax.validation.constraints.NotEmpty;

public class RegisterForm {
	@NotEmpty(message = "User Name must be not null!")
	private String username;
	@NotEmpty(message = "Password must be not null!")
	private String password;
	@NotEmpty(message = "Password confirm must be not null!")
	private String cfmpassword;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCfmpassword() {
		return cfmpassword;
	}
	public void setCfmpassword(String cfmpassword) {
		this.cfmpassword = cfmpassword;
	}
	public RegisterForm() {
		super();
	}
	
	
	
}
