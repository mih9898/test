package java112.project4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        name = "AnalyzerReadFileServlet",
        urlPatterns = { "/AnalyzerReadFileServlet" }
)
@MultipartConfig

public class AnalyzerReadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet - file upload
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        request.setAttribute("fullName", fileName);
        StringBuilder tokens = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
        while(br.ready()){
            tokens.append(br.readLine())
                    .append(System.lineSeparator());
        }

        request.setAttribute("tokens",tokens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/analyzer_output.jsp");
        dispatcher.forward(request, response);
    }



}
