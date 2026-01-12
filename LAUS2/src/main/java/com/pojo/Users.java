package com.pojo;

import java.sql.Date;

public class Users {
	private int userID;
	private String name;
	private String email;
	private String password;
	private double regAmt;
	private Date regDate;
	private String role;
	public Users(int userID, String name, String email, String password, double regAmt, Date date, String role) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmt = regAmt;
		this.regDate = date;
		this.role = role;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmt() {
		return regAmt;
	}
	public void setRegAmt(double regAmt) {
		this.regAmt = regAmt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", regAmt=" + regAmt + ", regDate=" + regDate + ", role=" + role + "]";
	}

}
