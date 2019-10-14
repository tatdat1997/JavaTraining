package com.springboothello.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable{
	
	@Id
    @Column(name="user_id", unique = true)
    private String user_id;
    
    @Column(name = "user_name", nullable = false, length = 100, unique = true)
    private String username;

    @Column(name = "password", nullable = true, length = 30)
    private String password;
   
	public User() {
		super();
	}
	 @Override
    public String toString() {
        return "User{" + "user_id='" + user_id + "user_name='" + username + '}'+""+super.toString();
    }

	public void setUser_id(String user_id) {
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
	public User(String user_id, String user_name, String password) {
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