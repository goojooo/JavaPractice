package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.utils.DBUtils.getConnection;

import com.pojo.Student;

public class StudentDaoImpl implements IStudentDAO {

    private Connection con;
    private PreparedStatement ps,ps1,ps2,ps3;

    public StudentDaoImpl() throws SQLException {
        con = getConnection();
        
        String sqlins = "insert into students values (default,?,?,?)";
        ps1=con.prepareStatement(sqlins);
        
        String sqludt = "update students set name = ?, addr = ? where stuid = ?";
    	ps2 = con.prepareStatement(sqludt);
    	
    	String sqldel = "delete from students where stuid=?";
    			ps3 = con.prepareStatement(sqldel);
        
    }
	
	@Override
	public List<Student> getStudentsDetails(int stuid, String name, String gender, String addr) throws SQLException {
		List<Student> list = new ArrayList<>();

	    String sql = "SELECT * FROM students";
	    ps = con.prepareStatement(sql);
	    var rs = ps.executeQuery();

	    while (rs.next()) {
	        Student s = new Student(
	            rs.getInt("stuid"),
	            rs.getString("name"),
	            rs.getString("gender"),
	            rs.getString("addr")
	        );
	        list.add(s);
	    }
	    return list;
	}

	@Override
	public String addStudentDetails(Student e) throws SQLException {
		ps1.setString(1,e.getName());
		ps1.setString(2,e.getGender());
		ps1.setString(3,e.getAddr());
		int count = ps1.executeUpdate();
		if(count==1) {
			return "Record inserted";
		} else {
			return "Record not inserted";
		}
	}

	@Override
	public String updateStudentDetails(int stuId, String newName, String newAddr) throws SQLException {
		ps2.setString(1, newName);
		ps2.setString(2, newAddr);
		ps2.setInt(3, stuId);
		int count = ps2.executeUpdate();
		
		if(count == 1) {
			return "Recorde updates successfully";
		} else{
			return "Recorde not updates successfully";
		}
	}
	@Override
	public String deleteStudentDetails(int stuId) throws SQLException {
		ps3.setInt(1,stuId);
	int count = ps3.executeUpdate();
		
		if(count == 1) {
			return "Recorde deled successfully";
		} else{
			return "Recorde not deleted successfully";
		}
		
	}
	
	public void close() throws SQLException{
		if(ps!=null)
			ps.close();
		
	}







}
