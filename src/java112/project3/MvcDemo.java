package java112.project3;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 * @author Eric Knapp
 *
 */
@WebServlet(
    name = "mvcDemo", 
    urlPatterns = { "/mvc-demo" }
)

/**
 * This app shows/practices to use
 * MVC pattern.
 * More precisely, this class
 * shows how controller works
 *
 * @author mturchanov
 */
public class MvcDemo extends HttpServlet {
 
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
 
        BeanOne myBean = new BeanOne();
        myBean.setData("I'm special!");
        myBean.setHeadTitle("MVC Demo - Lab4");
        request.setAttribute("myCoolBean", myBean);
 
        String url = "/beanOneDemo.jsp";
 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}