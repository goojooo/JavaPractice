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
     private PreparedStatement ps1,ps2,ps3;
   //constructor will be invoked exactly once by main()
    public EmployeeDaoImpl() throws SQLException
    {
    	//get connection from DButils
    	con=getConnection();
    	String sql= "select empid, name, salary, join_date " +
    		    "from my_emo where deptid=? and join_date between ? and ?";
    	 ps = con.prepareStatement(sql);
    	 
    	 
    	 String sqlins = "insert into my_emo values(default,?,?,?,?,?)";
    	 ps1 = con.prepareStatement(sqlins);
    	 
    	 String sqludt = "update my_emo set deptid = ?, salary = ? where empid = ?";
    	 ps2 = con.prepareStatement(sqludt);
    	 
    	 String sqldel = "delete from my_emo where empid = ? ";
    	 ps3 = con.prepareStatement(sqldel);
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
	@Override
	public String addEmployeeDetails(Employee e) throws SQLException {
		
//		List<Employee> ins = 
		ps1.setString(1,e.getName());
		ps1.setString(2, e.getAddress());
		ps1.setDouble(3, e.getSalary());
		ps1.setString(4, e.getDeptId());
		ps1.setDate(5, e.getJoinDate());
		int count = ps1.executeUpdate();
		if(count == 1) {
			return "Record inserted";
		} else {
			return "Record not inserted";
		}
	}
	@Override
	public String updateEmployeeDetails(int empid, String newdept, Double newsal) throws SQLException {
		
		ps2.setString(1, newdept);
		ps2.setDouble(2, newsal);
		ps2.setInt(3, empid);
		int count = ps2.executeUpdate();
		if(count == 1) {
			return "Recorde updates successfully";
		} else{
			return "Recorde not updates successfully";
		}
	}
	
	@Override
	public String deleteEmployeeDetails(int empid) throws SQLException {
		ps3.setInt(1, empid);
		int count = ps3.executeUpdate();
		if(count==1) {
			return "record deleted";
		}
		else {
			return "record not deleted";
		}
		
	}
	
	public void close() throws SQLException
	{
		if(ps!=null)
			ps.close();
		if(ps1!=null)
			ps1.close();
		if(ps2!=null)
			ps2.close();
		if(ps3!=null)
			ps3.close();
		if(con!=null)
			con.close();
		System.out.println("emp dao layer close");
	}
	//end of class




}