package java112.analyzer;

import java.io.*;

/**
 * This class analyzes a file
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
            processAnalyzers (arguments[0]);
            writeOutputFiles(arguments[0]);
        }
    }

    /**
     * Process analyzers.
     *
     * @param fileToRead the file to read
     */
    public void processAnalyzers(String fileToRead){
        distinctAnalyzer.processToken(getFileInput(fileToRead));
        summaryAnalyzer.processToken(getFileInput(fileToRead));
    }

    /**
     * Initialize analyzers.
     */
    public void initializeAnalyzers() {
        this.distinctAnalyzer = new DistinctTokensAnalyzer();
        this.summaryAnalyzer = new FileSummaryAnalyzer();
    }

    /**
     * Write output files.
     *
     * @param fileToRead the file to read
     */
    public void writeOutputFiles(String fileToRead){
        summaryAnalyzer.generateOutputFile(fileToRead, OUTPUT_SUMMARY_PATH);
        distinctAnalyzer.generateOutputFile(fileToRead, OUTPUT_DISTINCT_TOKENS_PATH);
    }

    /**
     * Output error message.
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
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path)))
        ) {
            while (br.ready()){
                sb.append(br.readLine()).append(System.lineSeparator());
            }
        } catch(FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}


