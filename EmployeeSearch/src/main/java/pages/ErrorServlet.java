package pages;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String errorMsg = (String) req.getAttribute("errorMsg");

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<h2 style='color:red'>Error</h2>");
        out.println(errorMsg);
    }
}
