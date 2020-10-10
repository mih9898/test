package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Properties;

@WebServlet(
        name = "ApplicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)


/**
 * This servlet adds
 * employee to DB
 *
 * @author     mturchanov
 */
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    /**
     * Initializes properties
     * and @see java112.employee.EmployeeDirectory.
     * Also sets them as context attributes
     */
    @Override
    public void init() {
        Properties properties = loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        ServletContext context = getServletContext();
        context.setAttribute("project4Properties", properties);
        context.setAttribute("employeeDirectory", employeeDirectory);
    }
}
