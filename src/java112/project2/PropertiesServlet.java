package java112.project2;

import java112.utilities.PropertiesLoader;

import java.io.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(
        name = "propertiesServlet",
        urlPatterns = { "/properties" }
)
/**
 *  This servlet loads
 *  and displays properties
 *  information
 *
 * @author    mturchanov
 */
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {
    public Properties properties;

    /**
     * Initializes {@link #properties}
     */
    @Override
    public void init() {
        properties = loadProperties("/project2.properties");
        try {
            properties.load(this.getClass().getResourceAsStream("/project2.properties"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Project2-info</TITLE></HEAD>");
        out.print("<BODY style='text-align:center; margin:0 auto;'>");
        out.print("<h1>Project 2 -- info</h1>");
        out.print("<a href='../java112/index.jsp'>Click to "
                + "redirect on a homepage</a><br/>");
        out.print("<table style='border:solid black 2px; padding:2em;"
                + " margin: 0 auto;'>");
        for (String key : properties.stringPropertyNames()) {
            out.printf("<tr><th style='padding:1em;'>%s</th>"
                    + "<td style='max-width:200px;'>%s</td></tr>",
                    key, properties.getProperty(key));
        }
        out.println("</table>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}