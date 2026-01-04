package com.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		String myemail = request.getParameter("email");
		String mypass = request.getParameter("pass1");
		
		PrintWriter out = response.getWriter();
		
		if(myemail.equals("admin@gmail.com") && mypass.equals("pass123"))
		{
//			request.setAttribute("name_key", "Nayan");
			
		HttpSession session = request.getSession();
		session.setAttribute("name_key", "Nayan");
		
		RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");	
		rd.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			out.print("Email ID or password is invalid...");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}
}
