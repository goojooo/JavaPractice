package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.TutorialDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.Tutorial;

public class TutorialListServlet extends HttpServlet {

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

        // Read topicId
        int topicId = Integer.parseInt(request.getParameter("topicId"));

        // Fetch tutorials
        TutorialDao dao = new TutorialDao();
        List<Tutorial> list = dao.getTutorialsByTopic(topicId);

        // HTML output
        out.println("<h2>Available Tutorials</h2>");
        out.println("<ul>");

        for (Tutorial t : list) {
            out.println("<li>");
            out.println("<a href='tutorialDetails?id=" + t.getId() + "'>");
            out.println(t.getTitle() + " (Visits: " + t.getVisits() + ")");
            out.println("</a>");
            out.println("</li>");
        }

        out.println("</ul>");
        out.println("<br>");
        out.println("<a href='topics'>Back to Topics</a>");
        out.println(" | ");
        out.println("<a href='logout'>Logout</a>");
    }
}
