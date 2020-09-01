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
     * Process text file
     * and count a number
     * of unique words
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        for(String str : token.split("\\W")) {
            if(!str.isEmpty()) {
                distinctTokens.add(str);
            }
        }
    }

    /**
     * Generate file with unique words
     *
     * @param inputFilePath  the input file path
     * @param outputFilePath the output file path
     */
    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (
                PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(outputFilePath)))
        ) {
            for(String s : distinctTokens){
                pw.println(s);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
