package dao;
import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface IEmployeeDAO {
	//add a method declaration for getting emp details
     List<Employee> getEmployeeDetails(String deptid,String beginDate,String endDate)
     throws SQLException;
     
     String addEmployeeDetails(Employee e) throws SQLException;
     
     String updateEmployeeDetails(int empid , String dept,Double sal) throws SQLException;
     
     String deleteEmployeeDetails(int empid) throws SQLException;
     
     
}
