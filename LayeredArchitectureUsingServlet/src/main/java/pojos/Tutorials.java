package pojos;

import java.util.Date;

public class Tutorials {
   
	private int tutorialId;
	private String tutorialName;
	private String author;
	private Date publishDate;
	private int visits;
	private int topicId;
	public Tutorials(int tutorialId, String tutorialName, String author, Date publishDate, int visits, int topicId) {
		super();
		this.tutorialId = tutorialId;
		this.tutorialName = tutorialName;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.topicId = topicId;
	}
	
	@Override
	public String toString() {
		return "Tutorials [tutorialId=" + tutorialId + ", tutorialName=" + tutorialName + ", author=" + author
				+ ", publishDate=" + publishDate + ", visits=" + visits + ", topicId=" + topicId + "]";
	}
	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public String getTutorialName() {
		return tutorialName;
	}
	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	
	
}
