package java112.analyzer;

import java.io.*;

public class FileAnalysis {
    private DistinctTokensAnalyzer distinctAnalyzer;
    private FileSummaryAnalyzer summaryAnalyzer;
    public static final int VALID_ARG_NUM = 1;

    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARG_NUM) {
            System.out.println("Please enter the right input to process");
        } else {
            distinctAnalyzer = new DistinctTokensAnalyzer();
            distinctAnalyzer.processToken(getFileInput(arguments[0]));
            summaryAnalyzer = new FileSummaryAnalyzer();
            WriteOutputFile(arguments[0], "/home/student/GitHubRepos/projects/output/summary.txt");
        }
    }

    public void WriteOutputFile (String fileToRead, String fileToWrite) {
        summaryAnalyzer.generateOutputFile(fileToRead, fileToWrite);
        distinctAnalyzer.generateOutputFile(fileToRead, fileToWrite);
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


