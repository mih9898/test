package java112.analyzer;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 *  create the report of all distinct tokens
 *
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    // Only allowed instance variable
    private Set<String> distinctTokens;

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    @Override
    public void processToken(String token) {
        for(String str : token.split("\\W")) {
            if(!str.isEmpty()) {
                distinctTokens.add(str);
            }
        }

        System.out.println("unique words: " + distinctTokens.size());
    }

    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, true)))) {
            pw.write("\nTotal Tokens: " + distinctTokens.size());
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
