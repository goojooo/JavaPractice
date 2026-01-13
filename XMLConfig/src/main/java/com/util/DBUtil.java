package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection(ServletContext context) {
        Connection con = null;

        try {
            String driver = context.getInitParameter("DB_DRIVER");
            String url = context.getInitParameter("DB_URL");
            String username = context.getInitParameter("DB_USERNAME");
            String password = context.getInitParameter("DB_PASSWORD");

            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
