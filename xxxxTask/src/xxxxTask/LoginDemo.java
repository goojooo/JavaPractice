import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDemo {
    public static void main(String[] args) throws Exception {

        String username = "admin";
        String password = "' OR '1'='1";

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/testdb",
            "root",
            "password"
        );

        Statement stmt = conn.createStatement();

        String sql =
            "SELECT * FROM users WHERE username = '" +
            username +
            "' AND password = '" +
            password +
            "'";

        System.out.println(sql); // VERY IMPORTANT to see the attack

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }

        conn.close();
    }
}
