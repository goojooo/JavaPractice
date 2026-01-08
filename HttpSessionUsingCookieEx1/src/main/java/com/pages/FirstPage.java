package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstPage
 */
@WebServlet("/firstPageUrl")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 


	public void init(ServletConfig config) throws ServletException {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("pname");
		String fname = request.getParameter("fname");
		String addr = request.getParameter("address");
		String mS = request.getParameter("ms");
		
		HttpSession session = request.getSession();
		session.setAttribute("pname", name);
		session.setAttribute("fname", fname);
		session.setAttribute("address", addr);
		session.setAttribute("ms", mS);
		
		if(mS.equalsIgnoreCase("married")) {
			pw.println("<form action='secondPageUrl' method='post'>");
			pw.println("Spouce Name : <input type='text' name='f2t1' />");
			pw.println("Number of kids : <input type='text' name='f2t2' />");
			pw.println("<input type='submit' value='Register' /> <input type='reset' value='Cancle' />");
			pw.println("</form>");
		}
		else {
			pw.println("<form action='secondPageUrl' method='post'>");
			pw.println("Why do you want to marry ? : <input type='text' name='f2t1' />");
			pw.println("When do you want to marry ?: <input type='text' name='f2t2' />");
			pw.println("<input type='submit' value='Register' /> <input type='reset' value='Cancle' />");
			pw.println("</form>");
		}
		pw.println("<br><br> session id::"+session.getId()+"</br>");
		pw.close();
	}

}
