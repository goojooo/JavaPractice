package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojos.User;

@WebServlet("/logout1")
public class LogOutServlet extends HttpServlet {
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
  // set cont type
    response.setContentType("text/html");
    // get PW
    try (PrintWriter pw = response.getWriter()) {
        // hello , user name
        // 1. get session
        HttpSession session = request.getSession();
        System.out.println("from logout page " + session.isNew()); // false (provided cookies are enabled!)
        System.out.println("Session ID " + session.getId()); // SAME for the same clnt
        // get user details from HS
        User userDetails = (User) session.getAttribute("user_details");
        if (userDetails != null) {
            pw.print("<h5> Hello , " + userDetails.getName() + "</h5>");

        } else // no cookies : no session tracking!
            pw.print("<h5>No Cookies : session tracking failed!!!!!!!</h5>");

        // invalidate session
        session.invalidate();
        pw.print("<h5> You have logged out....</h5>");
        // add a visit again link
        pw.print("<h5><a href='login.html'>Visit Again</a></h5>");      
 
}
 }
}

