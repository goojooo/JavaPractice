package pages;

import pojos.Employee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Employee emp = (Employee) req.getAttribute("employee");

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<h2>Employee Details</h2>");
        out.println("ID: " + emp.getId() + "<br>");
        out.println("Name: " + emp.getName() + "<br>");
        out.println("Department: " + emp.getDepartment());
    }
}
