package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		String myName = req.getParameter("name1");
		String myEmail = req.getParameter("email");
		String password = req.getParameter("pass1");
		String gender = req.getParameter("gender1");
		String city = req.getParameter("city1");
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_demo","root","gojo");
		
		PreparedStatement ps = con.prepareStatement("insert into register value(?,?,?,?,?)");
		ps.setString(1, myName);
		ps.setString(2, myEmail);
		ps.setString(3, password);
		ps.setString(4, gender);
		ps.setString(5, city);
		
		int count = ps.executeUpdate();
		if(count > 0)
		{
			resp.setContentType("text/html");
			out.print("<h3 style='color:green'>User register successfully </h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			out.print("<h3 style='red'>User not register due to some error ! </h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		resp.setContentType("text/html");
		out.print("<h3 style='red'> Exception occured"+ e.getMessage() +"</h3>");
		
		RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
		rd.include(req, resp);
	}
	}
}
