package pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SetContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        ServletContext context = getServletContext();

        context.setAttribute("appVersion", "1.0.0");
        context.setAttribute("adminName", "System Admin");

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<h2>Context Data Set Successfully</h2>");
        out.println("<a href='getContext'>View Context Data</a>");
    }
}
