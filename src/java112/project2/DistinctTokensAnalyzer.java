package java112.project2;

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
     */
    @Override
    public void generateOutputFile(String inputFilePath) {

    }
}
