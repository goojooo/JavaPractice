package pages;

import java.io.IOException;

import dao.IProductDao;
import dao.ProductDaoImpl;
import pojos.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product();
        product.setProductName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        IProductDao productDao = new ProductDaoImpl();
        boolean result = productDao.addProduct(product);

        if (result) {
            response.sendRedirect("dashboard");
        } else {
            response.getWriter().println("Error adding product");
        }
    }
}
