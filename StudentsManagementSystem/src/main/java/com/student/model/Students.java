package com.student.model;

public class Students {

	private int id ;
	private String Name;
	private String Email;
	private String Course;
	private int Age;
	
	// getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Course=" + Course + ", Age=" + Age
				+ "]";
	}
	
	
}
