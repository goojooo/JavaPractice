package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojo.Employee;

public class AddEmployeeDetailsTes {

	public static void main(String[] args) throws SQLException {
		 try(Scanner sc=new Scanner(System.in)){
			 EmployeeDaoImpl e=new EmployeeDaoImpl();
			  System.out.println("enter details name , addr,sal, deptid,joinDate");
			  String msg = e.addEmployeeDetails(new Employee(0, sc.next(),sc.next(),sc.nextDouble(),sc.next(),Date.valueOf(sc.next())));
			  System.out.println("Insertion "+ msg);
			  e.close();
//			  List<Employee> l=e.getEmployeeDetails(sc.next(),sc.next(),sc.next());
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
	}

}
