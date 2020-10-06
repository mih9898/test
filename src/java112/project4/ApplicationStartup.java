package java112.project4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)



public class ApplicationStartup extends HttpServlet {

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
//        TODO: Create a Properties object and load the project4.properties file.
//        TODO: Place the Properties object into the ServletContext
//            with an attribute name that is different from
//            the one used in other projects and labs.
//            Something like “project4Properties” would work.
//        TODO: Create an EmployeeDirectory instance with the constructor that has a Properties parameter.
//        TODO: Place the EmployeeDirectory instance into the ServletContext
    }
}
