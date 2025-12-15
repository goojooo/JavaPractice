package com.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.StudentDaoImpl;
import com.pojo.Student;

public class UpdateStudentDetailsTest {

	public static void main(String[] args) {
		 try(Scanner sc=new Scanner(System.in)) {
			 StudentDaoImpl s = new StudentDaoImpl();
			 System.out.println("Enter students details wnat to update : () ");
			 String msg = s.updateStudentDetails(sc.nextInt(),sc.next(),sc.next());
			  System.out.println("Updated  "+ msg);
			  s.close();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 

	}

}
}
