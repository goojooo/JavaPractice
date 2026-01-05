package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;
import com.student.model.Students;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Students s = new Students();
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		s.setAge(age);
		
		StudentDAO.save(s);
		resp.setContentType("text/html");
		out.print("<h3 style='color:green'>Student added successfully </h3>");
		
		RequestDispatcher rd = req.getRequestDispatcher("/addStudent.jsp");
		rd.include(req, resp);
//		resp.sendRedirect("viewStudents");
	}
}
