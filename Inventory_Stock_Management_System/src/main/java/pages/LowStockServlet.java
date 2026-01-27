package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.StockDaoImpl;
import pojos.Product;

@WebServlet("/lowStock")
public class LowStockServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        StockDaoImpl dao = new StockDaoImpl();
        List<Product> list = dao.getLowStockProducts(10);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Low Stock Products</h2>");

        for (Product p : list) {
            out.println(p.getProductName() + " - Qty: " + p.getQuantity() + "<br>");
        }
    }
}
