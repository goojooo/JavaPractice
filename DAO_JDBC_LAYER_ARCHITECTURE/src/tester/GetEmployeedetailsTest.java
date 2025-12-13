package tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojo.Employee;

public class GetEmployeedetailsTest {
   public static void main (String[] args) {
	   try(Scanner sc=new Scanner(System.in)){
		   EmployeeDaoImpl e=new EmployeeDaoImpl();
		   System.out.println("enter details deptid,begindate,enddate");
		   List<Employee> l=e.getEmployeeDetails(sc.next(),sc.next(),sc.next());
		   for(Employee i:l)
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