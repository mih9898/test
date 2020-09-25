package java112.project4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "JSTLLab1Servlet",
        urlPatterns = { "/jstl_lab1" }
)
public class JSTLLab1Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        list.add("Michal");
        list.add("Krzystof");
        list.add("Kasia");

        request.setAttribute("names", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jstl-lab2.jsp");
        dispatcher.forward(request, response);
    }
}
