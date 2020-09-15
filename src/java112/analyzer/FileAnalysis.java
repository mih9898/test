package java112.analyzer;

import java112.utilities.PropertiesLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class analyzes a file
 *
 * @author mturchanov
 */
public class FileAnalysis implements PropertiesLoader {
    public static final int VALID_ARG_NUM = 2;
    private List<TokenAnalyzer> analyzers;


    /**
     * Analyzes a file.
     *
     * @param arguments arguments that contains
     * a path to an input file
     */
    public void analyze(String[] arguments) {
        checkArguments(arguments);
        initializeAnalyzers(loadProperties(arguments[1]));
        processAnalyzers(arguments[0]);
        writeOutputFiles(arguments[0]);
        System.out.println("The app finished its work");
    }

    /**
     * Processes analyzers.
     *
     * @param fileToRead the file to read
     */
    public void processAnalyzers(String fileToRead){
        String words = getFileInput(fileToRead);
        for(String word : words.split("\\W")){
            if (!word.isEmpty()) {
                passTokensToAnalyzers(word);
            }
        }
    }

    /**
     * Passes tokens to analyzers
     *
     * @param token A token that is passed to the analyzers
     */
    public void passTokensToAnalyzers(String token) {
        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.processToken(token);
        }
    }

    /**
     * Initializes analyzers.
     */
    public void initializeAnalyzers(Properties properties) {
        analyzers = new ArrayList<>();
        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        analyzers.add(new LexicalDensityAnalyzer(properties));
    }

    /**
     * Writes output summaries.
     *
     * @param fileToRead the file to read
     */
    public void writeOutputFiles(String fileToRead){
        for(TokenAnalyzer analyzer : analyzers) {
            analyzer.generateOutputFile(fileToRead);
        }
    }

    /**
     * Checks whether it
     * is valid argument(s) number
     *
     * @param args passed command line arguments
     */
    public void checkArguments(String[] args) {
        if(args.length != VALID_ARG_NUM){
            System.out.println(args.length);
            System.out.println("Please enter the right input to process");
        }
    }

    /**
     * Gets file input.
     *
     * @param path the path
     * @return the file input
     */
    public String getFileInput(String path) {
        StringBuilder line = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(path))
        ) {
            while (bufferedReader.ready()){
                line.append(bufferedReader.readLine()).
                        append(System.lineSeparator());
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
        return line.toString();
    }
}


