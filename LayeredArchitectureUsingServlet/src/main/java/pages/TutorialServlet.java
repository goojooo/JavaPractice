import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dao.TutorialDaoImpl;


@WebServlet("/tutorials")
public class TutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			HttpSession session =request.getSession();
			TutorialDaoImpl tutimpl=(TutorialDaoImpl) session.getAttribute("tutorial_details");
		    String topic=request.getParameter("topic");
		   pw.print("<h4> All Tutorials under topic"+topic+"</h4></br>");
		   List<String>allTutorialbytopic=tutimpl.getAllTopicsByName(topic);
		   //dynamic Page
		   for(String tutName:allTutorialbytopic) {
			   pw.println(
				        "<a href='tutorial_details?name=" + tutName + "'>" 
				        + tutName + 
				        "</a><br/>"
				    );
			   //<a href='tutorial_details?name=Java'>Java</a>
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}