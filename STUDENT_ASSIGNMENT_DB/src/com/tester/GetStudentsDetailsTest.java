package com.tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dao.StudentDaoImpl;
import com.pojo.Student;

public class GetStudentsDetailsTest {

	public static void main(String[] args) {
		
		  try(Scanner sc=new Scanner(System.in)){
			   StudentDaoImpl e=new StudentDaoImpl();
			   System.out.println("Enter name gender address:");

			   List<Student> l=e.getStudentsDetails(0, sc.next(),sc.next(),sc.next());
			   for(Student i:l)
			   {
				   System.out.println("details are"+i);
			   }
			   e.close();
				   
			   
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
