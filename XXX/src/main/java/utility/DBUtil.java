package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL =
        "jdbc:mysql://localhost:3306/tutorial_db";
    private static final String USER = "root";
    private static final String PASSWORD = "gojo"; // change if needed

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
