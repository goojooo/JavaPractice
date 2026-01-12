package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	private static Connection con;

	public static Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  if(con==null) {
		   System.out.println("in if bock");
		  //get fixed connection
		   con = DriverManager.getConnection(
		       "jdbc:mysql://localhost:3306/db_demo","root", "gojo"
		   );
		   
		  }
		  return con;
		 }

}


