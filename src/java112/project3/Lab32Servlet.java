package java112.project3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Lab32Servlet",
        urlPatterns = { "/lab32" }
)

/**
 * This app shows/practices
 * to use HttpServletRequest
 *
 * @author mturchanov
 */
public class Lab32Servlet  extends HttpServlet  {

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
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Unit 3-Lab2</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Lab 3-2 — HTTP Request</h1>");
        out.print("<a href='../java112/index.jsp'>Click to "
                + "redirect on a homepage</a><br/>");
        out.print("<ul>");
        out.printf("<li>Current locale - %s</li>", request.getLocale());
        out.printf("<li>Context Path - %s</li>", request.getContextPath());
        out.printf("<li>Server local name - %s</li>", request.getLocalName());
        out.printf("<li>Scheme - %s</li>", request.getScheme());
        out.print("</ul>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
