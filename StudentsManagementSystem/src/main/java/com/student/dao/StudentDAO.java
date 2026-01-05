package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.student.model.Students;

public class StudentDAO {
	
	public static int save(Students s) {
		int status = 0;
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO student(Name,Email,Course,Age) VALUES(?,?,?,?)"
					);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getCourse());
			ps.setInt(4, s.getAge());
			
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
