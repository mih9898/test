package java112.project4;

import java112.analyzer.FileAnalysis;
import java112.utilities.PropertiesLoader;

import java.io.*;
import java.util.Properties;

/**
 * This class runs analyzer
 * and reads various
 * summaries
 *
 * @author mturchanov
 */
public class SummariesHandler {
    private Properties properties;
    public final String ROOT_PATH = new File("").getAbsolutePath() + "/";

    /**
     * Generate summaries.
     *
     * @param args the arguments with file to read
     * and properties locations
     */
    public void generateSummaries(String[] args) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        fileAnalysis.analyze(args);
    }

    /**
     * Instantiates a new Summaries handler
     * and sets properties
     *
     * @param properties the properties
     */
    public SummariesHandler(Properties properties) {
        this.properties = properties;
    }

    /**
     * Gets summary string.
     *
     * @return the string
     */
    public String getSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.summary"));
        return readSummary(path);
    }

    /**
     * Gets distinct tokens summary string.
     *
     * @return the distinct tokens summary
     */
    public String getDistinctTokensSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.distinct"));
        return readSummary(path);
    }

    /**
     * Gets largest tokens summary string.
     *
     * @return the largest tokens summary
     */
    public String getLargestTokensSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.largest.words"));
        String largestTokens = readSummary(path);
        if(largestTokens.isEmpty()){
            return "No words with specified length";
        }
        return largestTokens;
    }

    /**
     * Gets distinct counts summary string.
     *
     * @return the distinct counts summary
     */
    public String getDistinctCountsSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.distinct.counts"));
        return readSummary(path);
    }

    /**
     * Gets lexical summary string.
     *
     * @return the lexical summary
     */
    public String getLexicalSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.lexical.summary"));
        return readSummary(path);
    }

    /**
     * Gets tokens length summary string.
     *
     * @return the tokens length summary
     */
    public String getTokensLengthSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.token.lengths"));
        return readSummary(path);
    }

    /**
     * Gets search locations summary string.
     *
     * @return the search locations summary
     */
    public String getSearchLocationsSummary(){
        String path = String.format("%s%s%s", ROOT_PATH,
                properties.getProperty("output.directory"),
                properties.getProperty("output.file.token.search.locations"));
        return readSummary(path);
    }

    /**
     * Reads summary
     *
     * @param path path where summary is located
     * @return read summary
     */
    private String readSummary(String path) {
        StringBuilder summary = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while (bufferedReader.ready()) {
                summary.append(bufferedReader.readLine()).append("<br>");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Summary handler couldn't find an input file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Summary handler has i/o issues");
            ioException.printStackTrace();
        }
        return summary.toString();
    }
}