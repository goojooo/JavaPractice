package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilityTest {
	private static Connection con;
	public static Connection getConnection() throws SQLException {
		
		if(con==null) {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/stu1712","root","gojo");		}
		return con;
		
	}

}