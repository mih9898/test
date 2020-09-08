package java112.analyzer;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;


/**
 * This class analyzes
 * a number of distinct tokens in
 * a text file
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    private Set<String> distinctTokens;

    /**
     * This constructor initializes 
     * a distinct token analyzer
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    /**
     * Gets distinct tokens.
     *
     * @return the distinct tokens
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    /**
     * Processes text file
     * and counts a number
     * of unique words
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        distinctTokens.add(token);
    }

    /**
     * Generates file with unique words
     *
     * @param inputFilePath  the input file path
     * @param outputFilePath the output file path
     */
    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(outputFilePath)))
        ) {
            for(String word : distinctTokens) {
                printWriter.println(word);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "distinct tokens file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " distinct tokens file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a distinct tokens file");
            e.printStackTrace();
        }
    }
}
