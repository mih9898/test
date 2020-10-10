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

/**
 * This servlet adds
 * employee to DB
 *
 * @author     mturchanov
 */
public class AddEmployeeServlet extends HttpServlet {
    private EmployeeDirectory employeeDirectory;

    /**
     *  Handles HTTP POST requests
     *
     * @param request request
     * @param response response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("project4AddMessage", "New employee was added");;
        ServletContext context = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory)context
                .getAttribute("employeeDirectory");
        String employeeID = request.getParameter("employeeID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        String dept = request.getParameter("dept");
        String room = request.getParameter("room");
        String phone = request.getParameter("phone");
        employeeDirectory.addRecord(employeeID, firstName, lastName, ssn,
                dept, room, phone);
        response.sendRedirect("/java112/addEmployee");
    }
}
