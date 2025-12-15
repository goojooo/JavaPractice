package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojo.Employee;

public class UpdateEmployeeDetails {

	public static void main(String[] args) {
		
		 try(Scanner sc=new Scanner(System.in)){
			 EmployeeDaoImpl e=new EmployeeDaoImpl();
			  System.out.println("enter details empid, deptid, updated salary");
			  String msg = e.updateEmployeeDetails(sc.nextInt(), sc.next(), sc.nextDouble());
//			  String msg = e.addEmployeeDetails(new Employee(0, sc.next(),sc.next(),sc.nextDouble(),sc.next(),Date.valueOf(sc.next())));
			  System.out.println("Record Updated "+ msg);
			  e.close();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }

	}

}
