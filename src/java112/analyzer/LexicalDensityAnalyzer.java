package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The type Lexical density analyzer
 * that summarizes lexical density
 * of a text.
 */
public class LexicalDensityAnalyzer implements TokenAnalyzer {
    public  Set<String> functionWords;
    private Properties properties;
    private int totalTokensCount;
    private int lexicalWordsCounter;

    /**
     * Instantiates a new Lexical density analyzer
     * and initialize {@link #functionWords}
     */
    public LexicalDensityAnalyzer() {
        functionWords = new HashSet<>();
        loadFunctionWords();
    }

    /**
     * Instantiates a new Lexical density analyzer.
     * and initialize {@link #properties}
     * @param properties the properties
     */
    public LexicalDensityAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Reads function words
     * from a file and loads
     * function words to
     * {@link #properties}
     */
    public void loadFunctionWords() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("nonlexical_big_file.txt"))
        ) {
            while (bufferedReader.ready()){
                functionWords.add(bufferedReader.readLine().trim());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The input file was not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem while reading input file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with input file");
            e.printStackTrace();
        }
    }

    /**
     * Calculates lexical density
     *
     * @return Lexical density
     */
    public double calculateLexicalDensity() {
        return ((double)lexicalWordsCounter * 100) / totalTokensCount;
    }

    /**
     * Processes token
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        if(!functionWords.contains(token.toLowerCase())
                && !isNumber(token)) {
            lexicalWordsCounter++;
        }
        totalTokensCount++;
    }

    /**
     * Checks whether
     * a word is a number.
     *
     * @param word the string
     * @return the boolean
     */
    public static boolean isNumber(String word) {
        return word.matches("-?\\d+")
                || word.matches("-?\\d+[.,]\\d+");
    }

    /**
     * Generates output lexical density summary
     *
     * @param inputFilePath  the input file path
     */
    @Override
    public void generateOutputFile(String inputFilePath) {
        String summaryOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.lexical.summary");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(summaryOutputPath)))
        ) {
            printWriter.printf("%-11s%n%n%-20s%-11d%n%-20s%-11d%n%-20s%.2f %%%n",
                    "Lexical Density Summary", "Lexical words", lexicalWordsCounter,
                    "Total words", totalTokensCount,
                    "Lexical Density", calculateLexicalDensity());

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "distinct lexical analyzer file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " lexical analyzer file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a lexical analyzer file");
            e.printStackTrace();
        }
    }
}
