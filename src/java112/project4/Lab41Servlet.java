package java112.project4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Lab41Servlet",
        urlPatterns = { "/Lab41Servlet" }
)


/**
 * This servlet
 * processes GET parameters
 * and displays them
 *
 * @author mturchanov
 */
public class Lab41Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeeID = request.getParameter("employeeID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        String phone = request.getParameter("phone");
        String dept = request.getParameter("dept");
        String room = request.getParameter("room");

        response.setContentType("text/html");
        PrintWriter out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Unit 3-Lab2</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Lab 3 - HTML Form</h1>");
        out.print("<a href='../java112/index.jsp'>Click to "
                + "redirect on a homepage</a><br/><br>");
        out.println("<h2>Processed employee</h2>");
        out.printf("Employee ID: %s<br>", employeeID);
        out.printf("First Name: %s<br>", firstName);
        out.printf("Last Name: %s<br>", lastName);
        out.printf("SSN: %s<br>", ssn);
        out.printf("Phone Number: %s<br>", phone);
        out.printf("Department: %s<br>", dept);
        out.printf("Room: %s<br>", room);
        out.print("</BODY>");
        out.print("</HTML>");

//        JDBCPreparedStatement recordEmployee = new JDBCPreparedStatement();
//        if(employeeID.equals("")) {
//            recordEmployee.insertEmployees(firstName, lastName, ssn, phone, dept, room);
//        } else {
//            recordEmployee.insertEmployees(employeeID, firstName, lastName, ssn, phone, dept, room);
//        }
    }
}
