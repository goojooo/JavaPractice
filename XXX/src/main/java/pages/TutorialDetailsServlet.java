package pages;

import java.io.IOException;
import java.io.PrintWriter;

import dao.TutorialDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.Tutorial;

public class TutorialDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Session check
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            out.println("<h3>Please login first</h3>");
            out.println("<a href='login.html'>Login</a>");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));

        TutorialDao dao = new TutorialDao();

        // Increment visits
        dao.incrementVisits(id);

        // Fetch tutorial details
        Tutorial t = dao.getTutorialById(id);

        // HTML output
        out.println("<h2>" + t.getTitle() + "</h2>");
        out.println("<p><b>Author:</b> " + t.getAuthor() + "</p>");
        out.println("<p><b>Published On:</b> " + t.getPublishedDate() + "</p>");
        out.println("<p><b>Visits:</b> " + t.getVisits() + "</p>");
        out.println("<hr>");
        out.println("<p>" + t.getContent() + "</p>");

        out.println("<br><br>");
        out.println("<a href='javascript:history.back()'>Back</a>");
        out.println(" | ");
        out.println("<a href='logout'>Logout</a>");
    }
}
