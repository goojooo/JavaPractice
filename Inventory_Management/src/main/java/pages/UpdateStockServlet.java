package pages;

import java.io.IOException;

import dao.IStockDao;
import dao.StockDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateStockServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.html");
            return;
        }

        int productId = Integer.parseInt(request.getParameter("productId"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        String type = request.getParameter("type");

        IStockDao stockDao = new StockDaoImpl();
        boolean result = stockDao.updateStock(productId, qty, type);

        if (result) {
            response.sendRedirect("viewProducts");
        } else {
            response.getWriter().println("Stock update failed");
        }
    }
}
