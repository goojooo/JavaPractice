package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {

	private static final String query = "select id, bookName,bookAddition,bookPrice from bookData";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// get PrintWriter
		PrintWriter pw = resp.getWriter();
		
	// set Content type
		resp.setContentType("text/html");

	//Load Driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	//Gen Con
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_DB","root","gojo");
				PreparedStatement ps = con.prepareStatement(query);)
		{
	
			ResultSet rs = ps.executeQuery();
			pw.println("<table  border='1px solid black' style='margin:auto;'>");
			pw.println("<tr>");
			pw.println("<th> Book ID </th>");
			pw.println("<th> Book Name </th>");
			pw.println("<th> Book Eddition </th>");
			pw.println("<th> Book Price </th>");
			pw.println("<th> Edit </th>");
			pw.println("<th> Delete </th>");
			pw.println("</tr>");
		
			while(rs.next())
			{
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getFloat(4)+"</td>");
				pw.println("<td><a href='editScreen? id="+rs.getInt(1)+"'>Edit</a></td>");
				pw.println("<td><a href='deleteUrl? id="+rs.getInt(1)+"'>Delete</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			pw.println("<h3>"+e.getMessage()+"</h3>");
		}
		pw.println(" <a href='home.html'>HOME</a>");
			}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
