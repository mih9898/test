package java112.project2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "First112Servlet",
        urlPatterns = { "/first" }
)

public class First112Servlet  extends HttpServlet  {
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
        out.print("<HEAD><TITLE>Project2-Student Info</TITLE></HEAD>");
        out.print("<BODY style='text-align:center; margin:0 auto;'>");
        out.print("<h1>Student info</h1>");
        out.print("<a href='../java112/index.jsp'>Click to "
                + "redirect on a homepage</a><br/>");
        out.print("<table style='border:solid black 2px;"
                + " padding:2em; margin: 0 auto;'>");
        out.printf("<tr><th style='padding:1em;'>%s</th>"
                + "<td style='max-width:200px;'>%s</td></tr>", "Name",
                "Mykhailo Turchanov");
        out.printf("<tr><th style='padding:1em;'>%s</th>"
                + "<td style='max-width:200px;'>%s</td></tr>", "Class",
                "Advanced Java(Fall 2020)");
        out.printf("<tr><th style='padding:1em;'>%s</th>"
                + "<td style='max-width:200px;'>%s</td></tr>", "Image",
                "<img src='images/cat1.jpg' alt='cat' style='width:200px;'");
        out.print("</table>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
