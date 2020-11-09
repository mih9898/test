package java112.project3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "Lab33Servlet",
        urlPatterns = { "/lab33" }
)

/**
 * This app shows/practices to use
 * controller with view as
 * a part of MVC
 *
 * @author mturchanov
 */
public class Lab33Servlet  extends HttpServlet  {
    private Map<String, Object> map;

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        map = new HashMap<>();
        map.put("text", "Korelus inticus -- belum tires. Fetelus!");
        map.put("number", 666);
        map.put("html", "<span style='font-size:350%'>H</span>ere is <b>some HTML</b>");
        request.setAttribute("myMap", map);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lab33.jsp");
        dispatcher.forward(request, response);
    }
}
