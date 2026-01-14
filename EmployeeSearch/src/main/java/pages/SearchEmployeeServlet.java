package pages;

import dao.EmployeeDao;
import pojos.Employee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class SearchEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int empId = Integer.parseInt(req.getParameter("empId"));

            EmployeeDao dao = new EmployeeDao();
            Employee emp = dao.searchEmployee(empId);

            if (emp != null) {
                req.setAttribute("employee", emp);

                RequestDispatcher rd =
                        req.getRequestDispatcher("employeeResult");
                rd.forward(req, res);   // ✅ FORWARD
            } else {
                req.setAttribute("errorMsg", "Employee Not Found");
                RequestDispatcher rd =
                        req.getRequestDispatcher("error");
                rd.forward(req, res);   // ✅ FORWARD TO ERROR SERVLET
            }

        } catch (Exception e) {
            req.setAttribute("errorMsg", "Invalid Employee ID");
            RequestDispatcher rd =
                    req.getRequestDispatcher("error");
            rd.forward(req, res);
        }
    }
}
