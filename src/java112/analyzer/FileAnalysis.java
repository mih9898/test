package java112.analyzer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileAnalysis {
    private DistinctTokensAnalyzer distinctAnalyzer;
    private FileSummaryAnalyzer summaryAnalyzer;
    public static final int VALID_ARG_NUM = 1;
    public static final String OUTPUT_SUMMARY_PATH = "/home/student/GitHubRepos/projects/output/summary.txt";

    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARG_NUM) {
            System.out.println("Please enter the right input to process");
        } else {
            initializeAnalyzers();
            distinctAnalyzer.processToken(getFileInput(arguments[0]));
            summaryAnalyzer.processToken(getFileInput(arguments[0]));
//            summaryAnalyzer.processToken(distinctAnalyzer.getDistinctTokens().size());
            writeOutputFiles(arguments[0]);
        }
    }

    public void initializeAnalyzers() {
        this.distinctAnalyzer = new DistinctTokensAnalyzer();
        this.summaryAnalyzer = new FileSummaryAnalyzer();
    }

    public void writeOutputFiles (String fileToRead){
        summaryAnalyzer.generateOutputFile(fileToRead, OUTPUT_SUMMARY_PATH);
        distinctAnalyzer.generateOutputFile(fileToRead, OUTPUT_SUMMARY_PATH);
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

    public String getCurrentTime() {
        Date dd = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E MMM M HH:mm:ss z yyyy");
        //System.out.println(format.format(dd));
        return format.format(dd);
    }
    public String getLastModifiedTime (String path) {
        File file = new File(path);
        Date lastModified = new Date(file.lastModified());
        SimpleDateFormat format = new SimpleDateFormat("E MMM M HH:mm:ss z yyyy");
        //System.out.println(format.format(lastModified));
        return format.format(lastModified);
    }


    public long getFileSize (String path) {
        return new File(path).length();
    }

    public String getFileURI (String path) {
        return new File(path).toURI().toString();
    }
}


