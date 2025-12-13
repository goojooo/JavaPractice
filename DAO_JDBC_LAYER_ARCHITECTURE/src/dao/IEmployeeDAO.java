package dao;
import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface IEmployeeDAO {
	//add a method declaration for getting emp details
     List<Employee> getEmployeeDetails(String deptid,String beginDate,String endDate)
     throws SQLException;
     
     
}
