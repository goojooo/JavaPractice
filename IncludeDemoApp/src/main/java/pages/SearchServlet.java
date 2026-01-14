package pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Include Header
        RequestDispatcher rd1 = req.getRequestDispatcher("header");
        rd1.include(req, res);

        // Main Content
        String empId = req.getParameter("empId");

        out.println("<h3>Search Result</h3>");

        if ("101".equals(empId)) {
            out.println("Employee ID: 101 <br>");
            out.println("Name: Rahul <br>");
            out.println("Department: IT <br>");
        } else {
            out.println("<p style='color:red'>Employee Not Found</p>");
        }

        // Include Footer
        RequestDispatcher rd2 = req.getRequestDispatcher("footer");
        rd2.include(req, res);
    }
}
