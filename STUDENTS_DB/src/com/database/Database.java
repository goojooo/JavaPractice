package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db1312"
      + "?useSSL=false"
      + "&allowPublicKeyRetrieval=true"
      + "&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "gojo";

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

	public static void closePreparedStatement(PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}

	public static void closeConnection(Connection con) {
		// TODO Auto-generated method stub
		
	}
}
