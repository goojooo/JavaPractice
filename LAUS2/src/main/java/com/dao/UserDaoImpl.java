package com.dao;

import static utility.DBUtility.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Users;

public class UserDaoImpl implements IUserDao{

	// state
	 private Connection con;
	 private PreparedStatement ps;
	
	//Constructer
	public UserDaoImpl() throws ClassNotFoundException, SQLException {
		con = getConnection();
		ps = con.prepareStatement("select * from users where email = ? and password = ?");
		System.out.println("DAO created");
	}
	
	@Override
	public Users validate(String email, String password) throws SQLException {
		ps.setString(1, email);
		ps.setString(2, password);
		
		try(ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				return new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDate(6),rs.getString(7));
			}
		}
		
		
		
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if(ps != null) {
			ps.close();
		}
	}

}
