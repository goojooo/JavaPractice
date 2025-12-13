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
//		Connection con = Database.getConnection();
		T student = null;
		
		String sql =
			    "SELECT student_id, first_name, last_name, age, gender, department, grade " +
			    "FROM students WHERE student_id = ?";

//		PreparedStatement ps = con.prepareStatement(sql);
		
		   try (
		            Connection con = Database.getConnection();
		            PreparedStatement ps = con.prepareStatement(sql);
		        ) {
		
		ps.setInt(1, student_id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("student_id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			int age = rs.getInt("age");
			String gender = rs.getString("gender");
			String department = rs.getString("department");
			String grade = rs.getString("grade");
			
			student = new T(id, firstName, lastName, age, gender, department,grade);
			
			
		}
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
		Connection con = Database.getConnection();
		
		String sql = "insert into students(student_id,first_name,last_name,age,gender,department,grade) values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, t.getStudent_id());
		ps.setString(2, t.getFirstName());
		ps.setString(3, t.getLastName());
		ps.setInt(4, t.getAge());
		ps.setString(5, t.getGender());
		ps.setString(6, t.getDepartment());
		ps.setString(7, t.getGrade());
		
		int result = ps.executeUpdate();
		
		Database.closePreparedStatement(ps);
		Database.closeConnection(con);

		return result;
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
