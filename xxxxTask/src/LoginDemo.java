import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection road = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xx", "root", "gojo"
        );

        if (road != null) {
            System.out.println("Road established");
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        //  SQL with placeholders
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        // ✅ Prepare the statement
        PreparedStatement vehicle = road.prepareStatement(sql);

        //  Bind user input safely
        vehicle.setString(1, user);
        vehicle.setString(2, pass);

        System.out.println("Executing Query:");
        System.out.println(sql);

        ResultSet rs = vehicle.executeQuery();

        if (rs.next())
            System.out.println("LOGIN SUCCESS");
        else
            System.out.println("LOGIN FAILED");
    }
}
