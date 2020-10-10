package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.employee.Search;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "EmployeeSearchServlet",
        urlPatterns = { "/employeeSearchServlet" }
)

public class EmployeeSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDirectory");

        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");
        Search search = employeeDirectory.searchEmployeeDB(searchType, searchTerm);

        HttpSession session = request.getSession();
        session.setAttribute("search", search);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addPageDisplayServlet");
        dispatcher.forward(request, response);
    }
}
