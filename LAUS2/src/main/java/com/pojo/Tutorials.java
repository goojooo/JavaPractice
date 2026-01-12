package com.pojo;

import java.sql.Date;

public class Tutorials {
	private int tutorialId ;
	private String name;
	private String author;
	private Date date ;
	private int visits;
	private int topics_id;
	
	public Tutorials(int tutorialId, String name, String author, Date date, int visits, int topics_id) {
		super();
		this.tutorialId = tutorialId;
		this.name = name;
		this.author = author;
		this.date = date;
		this.visits = visits;
		this.topics_id = topics_id;
	}

	public int getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getTopics_id() {
		return topics_id;
	}

	public void setTopics_id(int topics_id) {
		this.topics_id = topics_id;
	}

	@Override
	public String toString() {
		return "Tutorials [tutorialId=" + tutorialId + ", name=" + name + ", author=" + author + ", date=" + date
				+ ", visits=" + visits + ", topics_id=" + topics_id + "]";
	}
	
	
	
}
