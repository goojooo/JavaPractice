package com.tester;

import java.sql.SQLException;

import com.dao.IStudentDAOImpl;
import com.dao.StudentsDAO;
import com.pojo.T;

public class GetStudentsDetailsTest {

	public static void main(String[] args) throws SQLException {


//		Connection con = Database.getConnection();
//		if(con!=null) {
//			System.out.println("Connection eshtablished...");
//		}
		StudentsDAO studentDao= new IStudentDAOImpl();
		T student = studentDao.get(2);
		
		System.out.println(student);
	}

}
