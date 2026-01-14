package pages;

import java.io.IOException;
import java.util.List;

import dao.IStockDao;
import dao.StockDaoImpl;
import pojos.StockTransaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class StockHistoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.html");
            return;
        }

        IStockDao stockDao = new StockDaoImpl();
        List<StockTransaction> history = stockDao.getStockHistory();

        request.setAttribute("historyList", history);
        request.getRequestDispatcher("stockHistory.jsp").forward(request, response);
    }
}
