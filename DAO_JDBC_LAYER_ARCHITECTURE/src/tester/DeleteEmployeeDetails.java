package tester;

import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class DeleteEmployeeDetails {

	public static void main(String[] args) {
		
		 try(Scanner sc=new Scanner(System.in)){
			 EmployeeDaoImpl e = new EmployeeDaoImpl();
			  System.out.println("enter empid");
			  String msg = e.deleteEmployeeDetails(sc.nextInt());
//			  String msg = e.addEmployeeDetails(new Employee(0, sc.next(),sc.next(),sc.nextDouble(),sc.next(),Date.valueOf(sc.next())));
			  System.out.println("Record deleted "+ msg);
			  e.close();
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }

	}

}
