package pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.StockDaoImpl;
import pojos.StockTransaction;

@WebServlet("/stockHistory")
public class StockHistoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        StockDaoImpl dao = new StockDaoImpl();
        List<StockTransaction> list = dao.getStockHistory();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Stock History</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Product ID</th><th>Qty</th><th>Type</th><th>Date</th></tr>");

        for (StockTransaction t : list) {
            out.println("<tr>");
            out.println("<td>" + t.getProductId() + "</td>");
            out.println("<td>" + t.getChangeQty() + "</td>");
            out.println("<td>" + t.getTxnType() + "</td>");
            out.println("<td>" + t.getTxnDate() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
    }
}
