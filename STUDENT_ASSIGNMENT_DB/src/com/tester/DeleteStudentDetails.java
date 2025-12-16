package com.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.StudentDaoImpl;

public class DeleteStudentDetails {

	public static void main(String[] args) {
		 try(Scanner sc=new Scanner(System.in)) {
			 StudentDaoImpl s = new StudentDaoImpl();
			 System.out.println("Enter students details wnat to delete : (Student ID) ");
			 String msg = s.deleteStudentDetails(sc.nextInt());
			  System.out.println("Updated  "+ msg);
			  s.close();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 

	}
	}

}
