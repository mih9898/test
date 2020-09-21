package java112.project3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "requestServlet",
        urlPatterns = { "/request-servlet" }
)


/**
 * This app shows/practices to use
 * controller with view as
 * a part of MVC
 *
 * @author mturchanov
 */
public class HttpRequestServlet  extends HttpServlet  {

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

        HttpRequestData data = new HttpRequestData();
        data.setRemoteAddress(request.getRemoteAddr());
        data.setContextPath(request.getContextPath());
        data.setHttpMethod(request.getMethod());
        data.setLocale(request.getLocale().getDisplayName());
        data.setLocalName(request.getLocalName());
        data.setPortName(request.getRemotePort());
        data.setQueryString(request.getQueryString());
        data.setQueryParameter(request.getParameter("queryParameter"));
        data.setRemoteComputer(request.getRemoteHost());
        data.setRequestProtocol(request.getProtocol());
        data.setRequestURL(request.getRequestURL().toString());
        data.setRequestURI(request.getRequestURI());
        data.setRequestHeader(request.getHeader("user-agent"));
        request.setAttribute("requestData", data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/requestData.jsp");
        dispatcher.forward(request, response);
    }
}
