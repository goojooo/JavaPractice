package pojos;

import java.sql.Date;

public class Tutorial {

    private int id;
    private String title;
    private String author;
    private String content;
    private Date publishedDate;
    private int visits;
    private int topicId;

    public Tutorial() {}

    public Tutorial(int id, String title, String author,
                    String content, Date publishedDate,
                    int visits, int topicId) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.publishedDate = publishedDate;
        this.visits = visits;
        this.topicId = topicId;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
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
