package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.User;

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        String name = "User";

        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                name = user.getName();
            }
            session.invalidate(); // 🔴 destroy session
        }

        out.println("<h2>Hello, " + name + "</h2>");
        out.println("<h3>You have logged out successfully</h3>");
        out.println("<a href='login.html'>Visit Again</a>");
    }
}
