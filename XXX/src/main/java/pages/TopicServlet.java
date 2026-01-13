package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.Topic;
import pojos.User;

public class TopicServlet extends HttpServlet {

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

        User user = (User) session.getAttribute("user");

        // Fetch topics
        TopicDao dao = new TopicDao();
        List<Topic> topics = dao.getAllTopics();

        // HTML output
        out.println("<h2>Welcome, " + user.getName() + "</h2>");
        out.println("<h3>Select a Topic</h3>");
        out.println("<ul>");

        for (Topic t : topics) {
            out.println("<li>");
            out.println("<a href='tutorials?topicId=" + t.getId() + "'>");
            out.println(t.getTopicName());
            out.println("</a>");
            out.println("</li>");
        }

        out.println("</ul>");
        out.println("<br>");
        out.println("<a href='logout'>Logout</a>");
    }
}
