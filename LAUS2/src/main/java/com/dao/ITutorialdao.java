package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Tutorials;

public interface ITutorialdao {
	List<String> getAllTopics() throws SQLException;
	Tutorials getTutirialDetails(String TutName) throws SQLException;
	String UpadteVisits() throws SQLException;
}
