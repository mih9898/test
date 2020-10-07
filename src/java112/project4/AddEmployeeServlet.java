package java112.project4;

import java112.employee.Employee;
import java112.employee.EmployeeDirectory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AddEmployeeServlet",
        urlPatterns = { "/addEmployeeServlet" }
)

public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDirectory");
        String employeeID = (String)request.getAttribute("employeeID");
        String firstName = (String)request.getAttribute("firstName");
        String lastName = (String)request.getAttribute("lastName");
        String ssn = (String)request.getAttribute("ssn");
        String dept = (String)request.getAttribute("dept");
        String room = (String)request.getAttribute("room");
        String phone = (String)request.getAttribute("phone");

        employeeDirectory.addRecord(employeeID, firstName, lastName, ssn,
                dept, room, phone);
        response.sendRedirect("jsp/add_employee.jsp");

    }
}
