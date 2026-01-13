package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojos.User;
import utility.DBUtil;

public class UserDao {

    public User validateUser(String email, String password) {

        User user = null;

        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user; // null if invalid
    }
}
