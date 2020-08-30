package java112.project1;

import java.util.Set;
import java.util.TreeSet;

/**
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

    }

    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {

    }
}
