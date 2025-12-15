package com.pojo;

public class Student {
	private int stuid;
	private String name;
	private String gender;
	private String addr;
	
	public Student(int stuid, String name, String gender, String addr) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.gender = gender;
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", gender=" + gender + ", addr=" + addr + "]";
	}

	
	public int getStuid() {
		return stuid;
	}


	public void setStuid(int stuid) {
		this.stuid = stuid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}

	
}
