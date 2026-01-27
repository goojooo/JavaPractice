package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojos.User;
import utility.DBUtility;

public class UserDaoImpl implements IUserDao {

	private static final String LOGIN_SQL = "SELECT * FROM users WHERE email=? AND password=?";

	@Override
	public User loginUser(String email, String password) {

		User user = null;

		try (Connection con = DBUtility.getConnection(); PreparedStatement ps = con.prepareStatement(LOGIN_SQL)) {
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"),
						rs.getString("password"), rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
