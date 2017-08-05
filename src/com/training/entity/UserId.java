package com.training.entity;

import java.io.Serializable;

public class UserId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String userName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public boolean equals(Object obj) {
		
		UserId id = (UserId) obj;

		return this.getEmail().equals(id.getEmail()) && this.getUserName().equals(id.getUserName());
	}
	
	@Override
	public int hashCode() {

		return 31 * this.getEmail().hashCode() + 31 * this.getUserName().hashCode();
	}
}
