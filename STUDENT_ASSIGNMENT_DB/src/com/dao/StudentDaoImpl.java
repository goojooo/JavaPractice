package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.pojo.Student;

public class StudentDaoImpl implements IStudentDAO {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public List<Student> getEmployeeDetails(int stuid, String name, String gender, String addr) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public StudentDaoImpl() throws SQLException {
//		con = getConnection();
//		String sqlins = "insert into students values(default,?,?,?)";
//		ps = con.prepareStatement(sqlins);
//	}

//	@Override
//	public String addStudentDetails(Student e) throws SQLException {
//		ps = setInt(1,e.getName());
//		ps= setString(2,e.getName());
//			
//	}
	
//	public void close() throws SQLException{
//		if(ps!=null)
//			ps.close();
//	}
	

}
