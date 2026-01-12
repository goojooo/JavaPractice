package dao;

import static utility.DBUtility.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDaoImpl implements IUserDao{
//state
	private Connection con;
	private PreparedStatement pst1;
	
	//constructor-->one time executing logic
	public UserDaoImpl() throws ClassNotFoundException, SQLException
	{
		con=getConnection();
		pst1=con.prepareStatement(" SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?");
		System.out.println("dao Created");
	}
	@Override
	public User validateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rs=pst1.executeQuery()){
			if(rs.next()) {
				return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDouble(5),rs.getDate(6),rs.getString(7));
				
			}
		}
		
		return null;
	}

	public void cleanUp()throws SQLException{
		if(pst1!=null)
			pst1.close();
	}
	
}
