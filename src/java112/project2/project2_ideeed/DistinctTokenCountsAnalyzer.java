package java112.project2.project2_ideeed;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * The type Distinct token counts analyzer
 * counts the number of unique tokens
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{

    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    /**
     * Instantiates a new Distinct token counts analyzer.
     * and initializes {@link #distinctTokenCounts}
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new TreeMap<>();
    }

    /**
     * Instantiates a new Distinct token counts analyzer
     * and initializes {@link #properties}
     *
     * @param properties the properties
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Gets distinct token counts.
     *
     * @return the distinct token counts
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     * Processes token,
     * counting occurrence
     * of each unique
     * token
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        distinctTokenCounts.put(token,
                distinctTokenCounts.getOrDefault(token, 0) + 1);
    }



    /**
     * Generates distinct token counts summary
     *
     * @param inputFilePath  the input file path
     */
    @Override
    public void generateOutputFile(String inputFilePath) {
        String summaryOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.distinct.counts");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(summaryOutputPath)))
        ) {
            for (Map.Entry<String, Integer> entry : distinctTokenCounts.entrySet()) {
                printWriter.printf("%s\t%s%n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "distinct counts tokens file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " distinct counts tokens file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a "
                    + "distinct counts tokens file");
            e.printStackTrace();
        }
    }
}
