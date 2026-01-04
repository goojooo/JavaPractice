package com.vaccine;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class EligibilityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get age from HTML form
        int age = Integer.parseInt(request.getParameter("age"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (age >= 18) {
            out.println("<h2>You are ELIGIBLE for Corona Vaccine</h2>");
        } else {
            out.println("<h2>You are NOT ELIGIBLE for Corona Vaccine</h2>");
        }

        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
