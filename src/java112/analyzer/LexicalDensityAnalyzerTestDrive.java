package java112.analyzer;

import java112.utilities.PropertiesLoader;
import java.util.*;

/**
 * The Lexical density analyzer test drive.
 */
public class LexicalDensityAnalyzerTestDrive implements PropertiesLoader {
    private Properties properties = loadProperties("/analyzer.properties");
    private final static String TEST_CASE_STRING = "john smith intensely loves "
            + "going to the huge cinema everyday";
    private final static int LEXICAL_DENSITY_RESULT = 80;

    /**
     * Gets lexical density
     * original result
     *
     * @return lexical density original result
     */
    private double testOriginalLexicalDensityAnalyzer(){
        LexicalDensityAnalyzer lexicalDensityAnalyzer =
                new LexicalDensityAnalyzer(properties);
        lexicalDensityAnalyzer.loadFunctionWords();
        for(String word : TEST_CASE_STRING.split("\\W")){
            lexicalDensityAnalyzer.processToken(word);
        }
        return lexicalDensityAnalyzer.calculateLexicalDensity();
    }

    /**
     * Launches test for
     * lexical analyzer
     * to check whether
     * it outputs the correct
     * result
     */
    public void launchTest() {
        double originalCaseResult = testOriginalLexicalDensityAnalyzer();
        String result = "Lexical density result: Expected - %d%%, Actual - %.2f%% - %s%n";


        if(LEXICAL_DENSITY_RESULT == originalCaseResult) {
            System.out.printf(result, LEXICAL_DENSITY_RESULT, originalCaseResult, "PASSED");
        } else {
            System.out.printf(result, LEXICAL_DENSITY_RESULT, originalCaseResult, "FAILED");
        }
    }

    /**
     * The entry point of application,
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new LexicalDensityAnalyzerTestDrive().launchTest();
    }
}
