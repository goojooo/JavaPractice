

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.UserDaoImpl;
import com.pojo.Users;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl u;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
	public void init() throws ServletException {
		try {
			u =  new UserDaoImpl();
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new ServletException("Err in init" + getClass().getName(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String mail = request.getParameter("email1");
		String pass = request.getParameter("pass1");
		try {
			Users user = u.validate(mail, pass);
			
			if(user == null) {
				pw.print("<h3> Invalid login, try again !</h3>");
			} else {
				pw.print("<h3 style='color:green; font-size:24px;'> Login successfull...</h3>");
				pw.print("<h3 style='color:blue; font-size:18px;'> Validate user details "+ user +"</h3>");
				response.sendRedirect("Topics");		}
		} catch (SQLException e) {
			throw new ServletException("Err in init" + getClass().getName(),e);
			
		}
	}

}
