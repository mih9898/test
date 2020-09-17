package java112.analyzer;

import java.io.*;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class analyzes
 * a number of unique tokens that
 * are greater than or equal to a specified number
 * of {@link #minimumTokenLength}
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {
    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    /**
     * Instantiates a new Largest tokens analyzer
     * and initializes {@link #largestTokens}
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<>();
    }

    /**
     * Instantiates a new Largest tokens analyzer,
     * initializes {@link #properties}
     * and sets {@link #largestTokens}
     *
     * @param properties the properties
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        this.minimumTokenLength = Integer.parseInt
                (properties.getProperty("largest.words.minimum.length"));
    }

    /**
     * Gets set of {@link #largestTokens}
     *
     * @return {@link #largestTokens}
     */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    /**
     * Counts a number
     * of unique words
     * of specific length
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        if(token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    /**
     * Generates largest tokens summary
     *
     * @param inputFilePath  the input file path
     */
    @Override
    public void generateOutputFile(String inputFilePath) {
        String largestWordsOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.largest.words");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(largestWordsOutputPath)))
        ) {
//            printWriter.println("Largest tokens Summary\n");
            for(String word : largestTokens) {
                printWriter.println(word);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "largest tokens file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " largest tokens file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a largest tokens file");
            e.printStackTrace();
        }
    }
}
