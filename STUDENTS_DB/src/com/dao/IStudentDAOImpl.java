package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.database.Database;
import com.pojo.T;

public class IStudentDAOImpl implements StudentsDAO{

	@Override
	public T get(int student_id) throws SQLException {
		Connection con = Database.getConnection();
		T student = null;
		
		String sql = "select student_id , firstName, lastName, age, gender, department,grade where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, student_id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int students_id = rs.getInt("student_id");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			int age = rs.getInt("age");
			String gender = rs.getString("gender");
			String department = rs.getString("department");
			String grade = rs.getString("garde");
			
			student = new T(student_id, firstName, lastName, age, gender, department,grade);
			
			
		}
		return student;
	}

	@Override
	public List<T> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(T students) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(T t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(T t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
