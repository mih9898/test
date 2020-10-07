package java112.project4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AddPageDisplayServlet",
        urlPatterns = { "/addPageDisplayServlet" }
)
public class AddPageDisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("project4AddMessage", "working");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add_employee.jsp");
        dispatcher.forward(request, response);
    }
}
