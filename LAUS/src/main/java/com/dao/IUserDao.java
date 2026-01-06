package com.dao;

import java.sql.SQLException;

import com.pojo.Users;

public interface IUserDao {
	Users validate(String email, String password) throws SQLException;
}
