import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import pojos.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import dao.UserDaoImpl;


@WebServlet(urlPatterns="/validate",loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl u;
	TopicDaoImpl topicDao;
	TutorialDaoImpl tutDao;
	public void init() throws ServletException {
		try {
			u=new UserDaoImpl();
			topicDao =new TopicDaoImpl();
			tutDao=new TutorialDaoImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			throw new ServletException("err in init"+getClass().getName(),e);
			
		}
		
	}

	
	public void destroy() {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String mail=request.getParameter("eml");
		String pass=request.getParameter("pass");
		try {
			User user=u.validateUser(mail, pass);
			
			if(user==null)
			{
				
				pw.print("<h3> invalid login Credentials,please retry </h3>");
				pw.print("<a href=  "+ "login.html"+ ">Back to login Page </a>");
			}
			else {
				//pw.print("<h3> login succesfull from LoginServlet</h3>");
			//pw.print("<h5> validated user details::"+user.toString()+"</h5>");
			//Cookie c1=new Cookie("email_name",request.getParameter("eml"));
			//Cookie c2=new Cookie("email_pass",request.getParameter("pass"));
			//
			//response.addCookie(c1);
			//response.addCookie(c2);
			//response.sendRedirect("topics");
				//servlet will ask web container either to create/get session obj
			HttpSession	session=request.getSession();
			System.out.println("from login page:"+session.isNew());//true
			System.out.println("session id from login page"+session.getId());
			//add validated user details under the session scope
			session.setAttribute("user_details", user);
			//add topic dao instance in http session object so that
			//it can be used accross multiple request
			session.setAttribute("topic_details",topicDao);
			session.setAttribute("tutorial_details",tutDao);
			response.sendRedirect("topics");
			
			
			
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			//throw new ServletException("err in init"+getClass().getName(),e); 
		}
	
		
		
	}

}