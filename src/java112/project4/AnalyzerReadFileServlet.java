package java112.project4;

import java112.utilities.PropertiesLoader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

@WebServlet(
        name = "AnalyzerReadFileServlet",
        urlPatterns = { "/AnalyzerReadFileServlet" }
)
@MultipartConfig

/**
 * This servlet reads file's
 * location, runs analyzer
 * and passes generated
 * summaries to View
 *
 * @author mturchanov
 */
public class AnalyzerReadFileServlet extends HttpServlet implements PropertiesLoader {
    private Properties properties;

    /**
     *  Handles HTTP Post requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName())
                .getFileName().toString();
        String pathToFile = new File("").getAbsolutePath() + "/" + fileName;

        String[] args = new String[2];
        args[0] = pathToFile;
        args[1] = "/analyzer.properties";

        SummariesHandler summariesHandler = new SummariesHandler(properties);
        summariesHandler.generateSummaries(args);

        request.setAttribute("fileTokensSummary", summariesHandler.getSummary());
        request.setAttribute("distinctTokensSummary", summariesHandler.getDistinctTokensSummary());
        request.setAttribute("largestTokensSummary", summariesHandler.getLargestTokensSummary());
        request.setAttribute("distinctCountsSummary", summariesHandler.getDistinctCountsSummary());
        request.setAttribute("lexicalSummary", summariesHandler.getLexicalSummary());
        request.setAttribute("tokensLengthSummary", summariesHandler.getTokensLengthSummary());
        request.setAttribute("searchLocationsSummary", summariesHandler.getSearchLocationsSummary());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/analyzer_output.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * loads analyzer properties to {@link #properties}
     */
    @Override
    public void init()  {
        properties = loadProperties("/analyzer.properties");
    }
}
