package pages;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		
		if(name.isEmpty()) {
			req.getRequestDispatcher("error").forward(req, resp);
		} else {
			req.getRequestDispatcher("success").forward(req, resp);
		}
	}

}
