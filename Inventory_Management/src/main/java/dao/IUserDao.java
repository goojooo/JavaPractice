package dao;

import pojos.User;

public interface IUserDao {

    User login(String username, String password);
}
