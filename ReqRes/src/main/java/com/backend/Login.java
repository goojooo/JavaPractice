package com.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mylogin")
public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException
	{
		String myemail = (String) request.getParameter("name1");
		String mypass = (String) request.getParameter("pass1");
		
		if(myemail.equals("admin@gmail.com") && mypass.equals("pass123")) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("NOT SUCCESS! Try again...");
		}
	}
}
