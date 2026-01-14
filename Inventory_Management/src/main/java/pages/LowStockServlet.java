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

public class LowStockServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.html");
            return;
        }

        int threshold = 5;

        IProductDao productDao = new ProductDaoImpl();
        List<Product> lowStockProducts = productDao.getLowStockProducts(threshold);

        request.setAttribute("lowStockList", lowStockProducts);
        request.getRequestDispatcher("lowStock.jsp").forward(request, response);
    }
}
