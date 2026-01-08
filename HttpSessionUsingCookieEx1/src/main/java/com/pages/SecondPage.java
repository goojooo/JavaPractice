package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondPage
 */
@WebServlet("/secondPageUrl")
public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		 String f2val1 = request.getParameter("f2t1");
	     String f2val2 = request.getParameter("f2t2");
	     
	     HttpSession session = request.getSession(false);
	     
	     String name = (String)session.getAttribute("name");
	     String fname = (String)session.getAttribute("fname");
	     String addrs = (String)session.getAttribute("addrs");
	     String ms = (String)session.getAttribute("ms");
	     
	     pw.println("<h1 style='color:red'>Two FORMS & REQUEST data </h1>");
	     
	     pw.println("<br><b> from1/req1 data :: "+name+"...."+fname+"....."+addrs+"....."+ms);
	     pw.println("<br><b> from2/req2 data :: "+f2val1+"...."+f2val2);
	     
	     session.invalidate();
	     
	     pw.println("<br><a href='index.html'>home </a>");
	     pw.println("<br><br> session id::"+session.getId()+"</br>");
	     
	     pw.close();

	}

}
