package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import dao.ProductDaoImpl;
import pojos.Product;

@WebServlet("/viewProducts")
public class ViewProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.html");
			return;
		}

		ProductDaoImpl dao = new ProductDaoImpl();
		List<Product> list = dao.getAllProducts();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h2>Products</h2>");
		out.println("<table border='1'>");
		out.println("<tr><th>ID</th><th>Name</th><th>Price</th><th>Qty</th></tr>");

		for (Product p : list) {
			out.println("<tr>");
			out.println("<td>" + p.getProductId() + "</td>");
			out.println("<td>" + p.getProductName() + "</td>");
			out.println("<td>" + p.getPrice() + "</td>");
			out.println("<td>" + p.getQuantity() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
