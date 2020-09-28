package java112.analyzer;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Token length analyzer
 * counts the number/occurrence of tokens' length
 */
public class TokenLengthsAnalyzer  implements TokenAnalyzer{

    private Map<Integer, Integer> tokenLengths;
    private Properties properties;
    private static final int MAX_HISTOGRAM_LENGTH = 80;

    /**
     * Instantiates a new token length analyzer.
     * and initializes {@links #tokenLength}
     */
    public TokenLengthsAnalyzer () {
        tokenLengths = new TreeMap<>();
    }

    /**
     * Instantiates a new token length analyzer
     * and initializes {@link #properties}
     *
     * @param properties the properties
     */
    public TokenLengthsAnalyzer (Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Gets token lengths
     *
     * @return the distinct token counts
     */

    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }
    /**
     * Processes token,
     * counting occurrence
     * of each token's length
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        int tokenLength = token.length();
        tokenLengths.put(tokenLength,
                tokenLengths.getOrDefault(tokenLength, 0) + 1);
    }

    /**
     * Gets the base, biggest
     * token length
     *
     * @return the base
     */
    public int getTheBase() {
        return Collections.max(tokenLengths.values());
    }

    public int calculateHistogramValue(int tokenLength) {
        double valueInHistogram = Math.round(((double)tokenLength / getTheBase()) * MAX_HISTOGRAM_LENGTH);
        if((int)valueInHistogram == 0) {
            valueInHistogram = 1;
        }
        return (int)valueInHistogram;
    }

    /**
     * Generates token length summary
     *
     * @param inputFilePath  the input file path
     */
    @Override
    public void generateOutputFile(String inputFilePath) {
        String summaryOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.token.lengths");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(summaryOutputPath)))
        ) {
            for (Map.Entry<Integer, Integer> entry : tokenLengths.entrySet()) {
//                printWriter.printf("%-20s%-11s%n", entry.getKey(), entry.getValue());
                printWriter.printf("%d\t%d%n", entry.getKey(), entry.getValue());
            }
            printWriter.println("\nHistogram: ");
            for (Map.Entry<Integer, Integer> entry : tokenLengths.entrySet()) {
                int valueInHistogram = calculateHistogramValue(entry.getValue());
                printWriter.printf("%d\t%s%n", entry.getKey(), "*".repeat(valueInHistogram));
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
