package com.itp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EligibilityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h3>Please submit the form from the home page.</h3>");
        out.println("<a href='page.html'>Go Back</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int age = Integer.parseInt(request.getParameter("age"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (age >= 18) {
            out.println("<h2>You are ELIGIBLE for Corona Vaccine ✅</h2>");
        } else {
            out.println("<h2>You are NOT ELIGIBLE for Corona Vaccine ❌</h2>");
        }

        out.println("<br><a href='page.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
