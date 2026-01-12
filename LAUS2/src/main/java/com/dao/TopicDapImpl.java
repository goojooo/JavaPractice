package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public static utiliy.DBUtility.getConnectiondb;

public class TopicDapImpl implements ITopicDao {

	private Connection con;
	private PreparedStatement ps;
	public TopicDapImpl () throws ClassNotFoundException, SQLException
	{
		con = getConnectiondb();
	}
	private Connection getConnectiondb() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> getAllTopics() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
