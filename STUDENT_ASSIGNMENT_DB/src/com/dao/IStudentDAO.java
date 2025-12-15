package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Student;



public interface IStudentDAO {
	
	List<Student> getStudentsDetails(int stuid ,String name,String gender, String addr) throws SQLException;
	
	String addStudentDetails(Student e) throws SQLException;
	
	String updateStudentDetails(int stuId, String newName, String newAddr) throws SQLException;

}
