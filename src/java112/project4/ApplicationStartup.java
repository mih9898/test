package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        name = "ApplicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)



public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        Properties properties = loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
//        log("\nemployee object is  \n" + employeeDirectory);
        ServletContext context = getServletContext();
        context.setAttribute("project4Properties", properties);
        context.setAttribute("employeeDirectory", employeeDirectory);
    }
}
