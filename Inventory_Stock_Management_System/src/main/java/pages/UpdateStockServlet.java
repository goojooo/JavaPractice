package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import dao.ProductDaoImpl;
import dao.StockDaoImpl;
import pojos.Product;
import pojos.StockTransaction;

@WebServlet("/updateStock")
public class UpdateStockServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        int pid = Integer.parseInt(request.getParameter("pid"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        String type = request.getParameter("type");

        ProductDaoImpl pdao = new ProductDaoImpl();
        Product p = pdao.getProductById(pid);

        int newQty = type.equals("IN") ? p.getQuantity() + qty : p.getQuantity() - qty;
        pdao.updateProductQuantity(pid, newQty);

        StockDaoImpl sdao = new StockDaoImpl();
        sdao.addStockTransaction(new StockTransaction(pid, qty, type));

        response.sendRedirect("dashboard.html");
    }
}
