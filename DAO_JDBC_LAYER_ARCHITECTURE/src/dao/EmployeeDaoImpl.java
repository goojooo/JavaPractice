package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Employee;
import static utils.DBUtils.getConnection;
public class EmployeeDaoImpl implements IEmployeeDAO {
   private Connection con;//state
     private  PreparedStatement ps;//state
   //constructor will be invoked exactly once by main()
    public EmployeeDaoImpl() throws SQLException
    {
    	//get connection from DButils
    	con=getConnection();
    	String sql= "select empid, name, salary, join_date " +
    		    "from my_emp where deptid=? and join_date between ? and ?";
    	 ps = con.prepareStatement(sql);
    	 System.out.println("emp dao Created");
    	
    }
	@Override
	public List<Employee> getEmployeeDetails(String deptid, String beginDate, String endDate) throws SQLException {
		// TODO Auto-generated method stub
		//set in params
		//create empty ArrayList
		List<Employee> l=new ArrayList<>();
		 ps.setString(1, deptid);
    	 ps.setDate(2, Date.valueOf(beginDate));
    	 ps.setDate(3,Date.valueOf(endDate));
    	 try (ResultSet rs = ps.executeQuery()) {
    	        while (rs.next()) {
    	            l.add(new Employee(
    	                    rs.getInt(1),
    	                    rs.getString(2),
    	                    rs.getDouble(3),
    	                    rs.getDate(4)
    	            ));
    	        }
    	    }

    	    return l;  // return must be *outside* the try block
    	}
	
	public void close() throws SQLException
	{
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
		System.out.println("emp dao layer close");
	}
	//end of class

}