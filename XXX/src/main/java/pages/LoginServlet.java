package pages;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.User;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.validateUser(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("topics");
        } else {
            out.println("<h3 style='color:red'>Invalid Email or Password</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
