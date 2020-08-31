package java112.analyzer;

import java.io.*;

public class FileAnalysis {
    private DistinctTokensAnalyzer distinctAnalyzer;
    private FileSummaryAnalyzer summaryAnalyzer;
    public static final int VALID_ARG_NUM = 1;

    /**
     * 1. The method tests if 1 cmd argument was entered. If the correct number is not entered then terminate
     * The method will then call other methods to perform these tasks:
     * 2. Create an instance of each Analyzer class and assign each instance to their respective instance variables:
     * summaryAnalyzer and distinctAnalyzer.
     * 3.Open the input file.
     * Loop through all the lines of the input file and generate individual tokens.
     * 4. Pass generated tokens to all Analyzer instances via the processToken() method.
     * 5. Call the generateOutputFile() method for each Analyzer class in a method named writeOutputFiles().
     *
     * @param arguments
     */
    public void analyze(String[] arguments) throws IOException {
        if (arguments.length != 1) {
            System.out.println("Please enter the right input to process");
        } else {
            distinctAnalyzer = new DistinctTokensAnalyzer();
            distinctAnalyzer.processToken(getFileInput(arguments[0]));
            summaryAnalyzer = new FileSummaryAnalyzer();
            summaryAnalyzer.generateOutputFile(arguments[0], "/home/student/GitHubRepos/projects/output/analysis.txt");
            distinctAnalyzer.generateOutputFile(arguments[0], "/home/student/GitHubRepos/projects/output/analysis.txt");
        }
    }

    public void writeOutputFiles (String fileToWrite) {

    }

    public String getFileInput(String path) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
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


