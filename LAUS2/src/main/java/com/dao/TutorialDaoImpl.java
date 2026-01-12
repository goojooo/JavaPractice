package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static utility.DBUtility.getConnection;

public class TutorialDaoImpl implements ITutorialdao {

	private Connection con;
	private PreparedStatement ps;
	public TutorialDaoImpl() throws SQLException, ClassNotFoundException{
		con = getConnection();
	}
}
