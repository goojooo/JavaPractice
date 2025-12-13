package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static String url = "jdbc:mysql://localhost:3306/student_db1312";
	private static String user = "root";
	private static String password = "gojo";
	
	private Database() {
		
	}
	
	public static Connection getConnection()throws SQLException{
		Connection connection ;
		connection = DriverManager.getConnection(url,user,password);
		
		return connection;
	}

}
