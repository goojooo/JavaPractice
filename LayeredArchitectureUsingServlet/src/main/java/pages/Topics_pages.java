import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dao.TopicDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/topics")
public class Topics_pages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h5> response givenn from Topic Page Servlet</h5>");
			// pw.print("<h3>Credentials are: " + request.getParameter("eml") + " " + request.getParameter("eml") + " </h3>");
		     //Cookie[] cookies=request.getCookies();     
		      //for(Cookie c : cookies)
		                
		            // pw.print("<h5> User fetched from a Cookie "+c.getValue()+"</h5>");
			//get/create HTTpsession from wc
			HttpSession hs=request.getSession();
			//returns Exiting hs object to the caller
			System.out.println("from topics page "+hs.isNew());//false
			//if its 2nd req then it will contain JsessionId as the cookie name
			System.out.println("Session Id"+hs.getId());//SAME session id
			//getdetails of the user which is stored into session attribute
			TopicDaoImpl dao=(TopicDaoImpl) hs.getAttribute("topic_details");
			List<String> allTopicNames=dao.getAllTopics();
			System.out.println("topic names"+allTopicNames);
			//for(String topicName:allTopicNames)
			//{
			//	pw.print(topicName+"</br>");
			//}
				
				pw.print("<form action='tutorials' method='post'>");
				pw.print("<h3 align='center'>All Topics</h3>");
				for (String topicName : allTopicNames) {
				    pw.print(
				        "<input type='radio' name='topic' value='" 
				        + topicName + "' required> "
				        + topicName + "<br/>"
				    );
				}

				pw.print("<br/>");
				pw.print("<input type='submit' value='Choose Topic'>");
				pw.print("</form>");

			
			//if(user !=null)
				//pw.println("<h5>from topic page servlet "+user+"</h5>");
			//else//no session tracking
				//pw.print("<h5>:session tracking failed !!!!!</h5>");
			
			//add alogout link
			//pw.println("</h5> <a href='logout1'>LOG OUT</a></h5>");
			
			
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		 
		 


		 }
		}