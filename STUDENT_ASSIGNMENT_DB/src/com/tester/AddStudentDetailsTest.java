package com.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.StudentDaoImpl;
import com.pojo.Student;

public class AddStudentDetailsTest {

	public static void main(String[] args) throws SQLException {
		 try(Scanner sc=new Scanner(System.in)) {
			 StudentDaoImpl s = new StudentDaoImpl();
			 System.out.println("Enter students details : ");
			 String msg = s.addStudentDetails(new Student(0,sc.next(),sc.next(),sc.next()));
			  System.out.println("Insertion "+ msg);
			  s.close();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }

	}

}
