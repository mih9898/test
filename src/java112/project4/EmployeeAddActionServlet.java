package java112.project4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "EmployeeAddActionServlet",
        urlPatterns = { "/employeeAddAction" }
)

public class EmployeeAddActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: access the EmployeeDirectory instance from
        //      the ServletContext that was placed there by the Application Start Servlet.
        //TODO: Call the add employee method in the EmployeeDirectory
        //      instance and pass the form data as arguments.
        //TODO: Add the returned message to the session.
        //      Send a redirect the browser to the Add Employee page
    }
}
