package java112.project4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "Project4SessionLab",
        urlPatterns = { "/Project4SessionLab" }
)


/**
 * This servlet
 * initializes and
 * process session
 * counter
 *
 * @author mturchanov
 */
public class Project4SessionLab extends HttpServlet {

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
        Integer project4SessionCounter = (Integer) session.getAttribute("project4SessionCounter");
        if(project4SessionCounter == null) {
            session.setAttribute("project4SessionCounter", 1);
            project4SessionCounter = 1;
        } else {
            session.setAttribute("project4SessionCounter", ++project4SessionCounter);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/project4Session.jsp");
        dispatcher.forward(request, response);
    }
}
