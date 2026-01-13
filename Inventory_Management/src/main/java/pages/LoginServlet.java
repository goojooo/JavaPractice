package pages;

import java.io.IOException;

import dao.IUserDao;
import dao.UserDaoImpl;
import pojos.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        IUserDao userDao = new UserDaoImpl();
        User user = userDao.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user);
            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
