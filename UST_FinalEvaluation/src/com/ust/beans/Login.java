package com.ust.beans;

public class Login {
	
	private int userId;
	private String username;
	private String password;
	
	//constructor with superclass
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//constructor using fields
	public Login(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	
	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	//toStrig()
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	

}
