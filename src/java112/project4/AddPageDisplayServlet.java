package java112.project4;

import java112.employee.Search;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "AddPageDisplayServlet",
        urlPatterns = { "/addPageDisplayServlet" }
)

/**
 * This servlet adds
 * appropriate heading
 * to session and forwards
 * to the output webpage
 *
 * @author     mturchanov
 */
public class AddPageDisplayServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests
     *
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Search search = (Search)session.getAttribute("search");
        if(search.isFound()){
            request.setAttribute("project4AddMessage",
                    "Requested employee(s) ");
        } else {
            request.setAttribute("project4AddMessage",
                    "There is no employee with such attribute");
        }
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/employees_search_results.jsp");
        dispatcher.forward(request, response);
    }
}
