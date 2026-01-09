package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final String query = "insert into bookData(bookName,bookEdition,bookPrice) values(?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// get PrintWriter
		PrintWriter pw = resp.getWriter();
		
	// set Content type
		resp.setContentType("text/html");
	//Get the book info
		String bookName = req.getParameter("bookName");
		String bookEdition = req.getParameter("bookEdition");
		float bookPrice = Float.parseFloat("bookPrice");
	//Load Driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	//Gen Con
		try(Connection con = DriverManager.getConnection("jdbc:mysql//Library_DB","root","gojo");
				PreparedStatement ps = con.prepareStatement(query);)
		{
			ps.setString(1, bookName);
			ps.setString(2, bookEdition);
			ps.setFloat(3, bookPrice);
			
			int count = ps.executeUpdate();
			
			if(count==1)
			{
				pw.println("<h3>record is Register successfully</h3>");
			} 
			else
			{
				pw.println("<h3>record is Not Register successfully</h3>");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			pw.println("<h3>"+e.getMessage()+"</h3>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
