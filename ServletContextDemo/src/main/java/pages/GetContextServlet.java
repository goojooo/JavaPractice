package pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GetContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        ServletContext context = getServletContext();

        String company = context.getInitParameter("companyName");
        String email = context.getInitParameter("supportEmail");

        String version = (String) context.getAttribute("appVersion");
        String admin = (String) context.getAttribute("adminName");

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<h2>Application Context Data</h2>");
        out.println("Company Name: " + company + "<br>");
        out.println("Support Email: " + email + "<br><br>");

        out.println("App Version: " + version + "<br>");
        out.println("Admin Name: " + admin);
    }
}
