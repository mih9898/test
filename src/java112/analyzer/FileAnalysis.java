package java112.analyzer;

import java.io.*;

/**
 * This class analyzes a file
 *
 * @author mturchanov
 */
public class FileAnalysis {
    public static final int VALID_ARG_NUM = 1;
    public static final String OUTPUT_SUMMARY_PATH =
            "/home/student/GitHubRepos/projects/output/summary.txt";
    public static final String OUTPUT_DISTINCT_TOKENS_PATH =
            "/home/student/GitHubRepos/projects/output/distinct_tokens.txt";
    private DistinctTokensAnalyzer distinctAnalyzer;
    private FileSummaryAnalyzer summaryAnalyzer;

    /**
     * Analyzes a file.
     *
     * @param arguments arguments that contains
     * a path to an input file
     */
    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARG_NUM) {
            outputErrorMessage();
        } else {
            initializeAnalyzers();
            processAnalyzers(arguments[0]);
            writeOutputFiles(arguments[0]);
            System.out.println("The app finished its work");
        }
    }

    /**
     * Processes analyzers.
     *
     * @param fileToRead the file to read
     */
    public void processAnalyzers(String fileToRead){
        distinctAnalyzer.processToken(getFileInput(fileToRead));
        summaryAnalyzer.processToken(getFileInput(fileToRead));
    }

    /**
     * Initializes analyzers.
     */
    public void initializeAnalyzers() {
        this.distinctAnalyzer = new DistinctTokensAnalyzer();
        this.summaryAnalyzer = new FileSummaryAnalyzer();
    }

    /**
     * Writes output files.
     *
     * @param fileToRead the file to read
     */
    public void writeOutputFiles(String fileToRead){
        summaryAnalyzer.generateOutputFile(fileToRead, OUTPUT_SUMMARY_PATH);
        distinctAnalyzer.generateOutputFile(fileToRead, OUTPUT_DISTINCT_TOKENS_PATH);
    }

    /**
     * Outputs error message.
     */
    public void outputErrorMessage() {
        System.out.println("Please enter the right input to process");
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


