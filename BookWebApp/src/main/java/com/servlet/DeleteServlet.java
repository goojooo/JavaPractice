package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUrl")
public class DeleteServlet extends HttpServlet {
	private static final String query = "delete from bookData where id = ?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// get PrintWriter
		PrintWriter pw = resp.getWriter();
		
	// set Content type
		resp.setContentType("text/html");
		
	// get the id record 
		int id = Integer.parseInt(req.getParameter("id"));


		
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
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if(count==1)
			{
				pw.println("<h2>Record is deleted successfully</h2>");
			}else
			{
				pw.println("<h2>Record is not deleted !!!</h2>");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			pw.println("<h3>"+e.getMessage()+"</h3>");
		}
		pw.println(" <a href='home.html'>HOME</a>");
		pw.println(" <br>");
		pw.println(" <a href='bookList'>Book List</a>");
			}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
