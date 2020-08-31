package java112.analyzer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * creates the summary report
 *
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {
    // Only allowed instance variable
    protected int totalTokensCount;

    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    @Override
    public void processToken(String token) {
        totalTokensCount = token.split(" ").length;
    }
    public void processToken(int totalTokensCount) {
        this.totalTokensCount = totalTokensCount;
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

    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
           pw.write(createReport(inputFilePath));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String createReport (String inputFilePath) {
        String summary = "Application: %s%n" +
                "Author: %s%n" +
                "Author email: %s%n" +
                "File: %s%n" +
                "Date of analysis: %s%n" +
                "Last modified: %s%n" +
                "File Size: %d%n" +
                "File URI: %s%n" +
                "Total Tokens: %d%n";

        return String.format(summary, "Analyzer", "Mike Turchanov", "mturchanov@madisoncolege.edu", inputFilePath, getCurrentTime(),
                getLastModifiedTime(inputFilePath), getFileSize(inputFilePath), getFileURI(inputFilePath), totalTokensCount);
    }
}
