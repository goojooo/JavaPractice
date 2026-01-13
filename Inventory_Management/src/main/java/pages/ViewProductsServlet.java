package pages;

import java.io.IOException;
import java.util.List;

import dao.IProductDao;
import dao.ProductDaoImpl;
import pojos.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.html");
            return;
        }

        IProductDao productDao = new ProductDaoImpl();
        List<Product> productList = productDao.getAllProducts();

        request.setAttribute("products", productList);
        request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
    }
}
