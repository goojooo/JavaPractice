package pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FooterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter out = res.getWriter();

        out.println("<hr>");
        out.println("<center>");
        out.println("<p>© 2026 Employee Portal</p>");
        out.println("<p>Developed by Nayan</p>");
        out.println("</center>");
        out.println("<hr>");
    }
}
