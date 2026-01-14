package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String user = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		PrintWriter pw = resp.getWriter();
		
		if(user.equals("admin") && pass.equals("123")) {
			pw.println("Login successfull");
		} else 
		{
			pw.print("Invalid param");
		}
	}

}
