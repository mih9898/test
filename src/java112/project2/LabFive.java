package java112.project2;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


//Build and deploy your servlet. Do NOT access the servlet in the browser yet! - no logs. just system messages
//Now, access the servlet in the browser. - init + doGet
//destroy log when server goes down or intentionally call the method


@WebServlet(
        name = "labFive",
        urlPatterns = { "/lab-five" }
)

/**
 * This app shows the life
 * stages of a servlet by
 * logging each stage
 *
 * @author mturchanov
 */
public class LabFive extends HttpServlet {
    private static int accessedNum = 0;
    private Date firstAccessed;

    /**
     * Initializes time when
     * a servlet was firstly accesed
     *
     * @throws ServletException Servlet Exception
     */
    @Override
    public void init() throws ServletException {
        log("Method init() executes");
        setFirstAccessed();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter  out  = resp.getWriter();

        log("Method doGet() executes");
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Lab five</h1>");
        out.print("<table>");
        out.print("<tr><th>Accessed Times</th><td>" + ++accessedNum + "</td></tr>");
        out.print("<tr><th>Current Time:</th><td>" + getCurrentTime() + "</td></tr>");
        out.print("<tr><th>First Accessed</th><td> " + getFirstAccessed() + "</td></tr>");
        out.print("</table>");
        out.print("</BODY>");
        out.print("</HTML>");
//        destroy();
    }

    @Override
    public void destroy() {
        log("destroy() method executes");
    }

    /**
     * Gets current time.
     *
     * @return Current time.
     */
    public String getCurrentTime() {
        return new Date().toString();
    }

    /**
     * Sets time when
     * a servlet was firstly accessed.
     */
    public void setFirstAccessed() {
            firstAccessed = new Date();
    }

    /**
     * Gets time when
     * a servlet was firstly accessed.
     *
     * @return time when
     * a servlet was firstly accessed
     */
    public Date getFirstAccessed() {
        return firstAccessed;
    }
}


