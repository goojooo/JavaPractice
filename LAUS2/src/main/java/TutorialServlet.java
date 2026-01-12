

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.TutorialDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TutorialServlet
 */
@WebServlet("/TutorialServlet")
public class TutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			HttpSession session = request.getSession();
			TutorialDaoImpl tutorailDaoImpl = (TutorialDaoImpl) session.getAttribute("");
		}
	}



}
