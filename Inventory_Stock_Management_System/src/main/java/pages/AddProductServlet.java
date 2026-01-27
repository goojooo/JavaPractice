package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import dao.ProductDaoImpl;
import pojos.Product;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));

        ProductDaoImpl dao = new ProductDaoImpl();
        dao.addProduct(new Product(name, price, qty));

        response.sendRedirect("dashboard.html");
    }
}
