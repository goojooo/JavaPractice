package pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HeaderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        out.println("<hr>");
        out.println("<marquee behavior='alternate' style='color:blue;'>");
        out.println("Welcome to Employee Management System");
        out.println("</marquee>");
        out.println("<hr>");
    }
}
