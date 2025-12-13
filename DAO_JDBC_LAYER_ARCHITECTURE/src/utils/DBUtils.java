package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection con;

	public static Connection getConnection() throws SQLException 
	{
			if(con==null)
			
			 con =  DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/db2", "root", "Root"
				);
		
		return con;
	}
	

}