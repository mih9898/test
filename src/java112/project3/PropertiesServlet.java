package java112.project3;

import java112.utilities.PropertiesLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "project3PropertiesServlet",
        urlPatterns = { "/project3-properties" }
)

/**
 * This app shows/practices
 * to use HttpServletRequest
 *
 * @author mturchanov
 */
public class PropertiesServlet  extends HttpServlet implements PropertiesLoader {
    private Properties properties;

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
        request.setAttribute("properties", properties);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/properties.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void init()  {
        properties = loadProperties("/project3.properties");
    }
}
