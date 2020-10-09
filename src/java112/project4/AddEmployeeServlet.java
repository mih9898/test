package java112.project4;

import java112.employee.Employee;
import java112.employee.EmployeeDirectory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "AddEmployeeServlet",
        urlPatterns = { "/addEmployeeServlet" }
)

public class AddEmployeeServlet extends HttpServlet {
    private EmployeeDirectory employeeDirectory;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("project4AddMessage", "New employee was added");;
        ServletContext context = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context.getAttribute("employeeDirectory");
        String employeeID = request.getParameter("employeeID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        String dept = request.getParameter("dept");
        String room = request.getParameter("room");
        String phone = request.getParameter("phone");
        log("\n" + String.format("Record on %s %s %s %s %s %s %s was added%n",
                employeeID,firstName, lastName,ssn,dept,room,phone) + "\n");
        employeeDirectory.addRecord(employeeID, firstName, lastName, ssn,
                dept, room, phone);
        response.sendRedirect("/java112/addEmployee");
    }
}
