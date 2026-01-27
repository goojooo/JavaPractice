package dao;

import pojos.User;

public interface IUserDao {

	User loginUser(String email, String password);
}
