package com.rain.domain;

import java.io.Serializable;

public class Root implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String loginname;
	private String password;
	
	public Root(){
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
