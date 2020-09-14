package java112.analyzer;

import java112.utilities.PropertiesLoader;
import java.util.*;

/**
 * The Lexical density analyzer test drive.
 */
public class LexicalDensityAnalyzerTestDrive implements PropertiesLoader {
    private Properties properties = loadProperties("/analyzer.properties");
    private String testCaseString = "john smith intensely loves "
            + "going to the huge cinema everyday";

    /**
     * Gets lexical density
     * tested result
     *
     * @return lexical density right result
     */
    private double testLexicalDensityAnalyzer() {
        int totalWordsCounter = 0;
        int totalLexicalWordsCounter = 0;
        LexicalDensityAnalyzer testAnalyzer = new LexicalDensityAnalyzer(properties);
        testAnalyzer.loadFunctionWords();
        for (String word : testCaseString.split("\\W")){
            if(!testAnalyzer.functionWords.contains(word.toLowerCase())
                    && !word.matches("\\d?([.,]\\d)")
                    && !word.matches("\\w+'[dl]")) {
                totalLexicalWordsCounter++;
            }
            totalWordsCounter++;
        }
        return (double)totalLexicalWordsCounter * 100 / totalWordsCounter;
    }

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
        for(String word : testCaseString.split("\\W")){
            lexicalDensityAnalyzer.processToken(word);
        }
        return lexicalDensityAnalyzer.calculateLexicalDensity();
    }

    /**
     * The entry point of application,
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LexicalDensityAnalyzerTestDrive testDrive =
                new LexicalDensityAnalyzerTestDrive();
        double testCaseResult = testDrive.testLexicalDensityAnalyzer();
        double originalCaseResult = testDrive.testOriginalLexicalDensityAnalyzer();
        System.out.printf("Testing lexical result is %.2f%n", testCaseResult);
        System.out.printf("Original lexical result is %.2f%n", originalCaseResult);

        if((Math.abs(testCaseResult - originalCaseResult)) < 5) {
            System.out.println("Lexical Density Analyzer's result "
                    + "is satisfactory (within ~5% range)");
        } else {
            System.out.println("Lexical Density Analyzer's result "
                    + "is not satisfactory (not within ~5% range)");
        }
    }
}
