package java112.project2.project2_ideeed;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class analyzes tokens from
 * provided input text file
 * and creates a summary
 * of it
 *
 * @author mturchanov
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {
    private int totalTokensCount;

    /**
     * Gets total tokens count.
     *
     * @return the total tokens count
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
     * Processes text and sets a number of 
     * unique words for 
     * {@link #totalTokensCount}
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        totalTokensCount++;
    }

    /**
     * Gets current time.
     *
     * @return the current time
     */
    public String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "E MMM M HH:mm:ss z yyyy");
        return formatter.format(date);
    }

    /**
     * Gets file's last modified time.
     *
     * @param path the path
     * @return the file's last modified time
     */
    public String getsFileLastModifiedTime(String path) {
        File file = new File(path);
        Date lastModified = new Date(file.lastModified());
        SimpleDateFormat format = new SimpleDateFormat(
                "E MMM M HH:mm:ss z yyyy");
        return format.format(lastModified);
    }
    public String getFileAbsolutePath(String file) {
        return new File(file).getAbsolutePath();
    }

    /**
     * Gets file size.
     *
     * @param path the path
     * @return the file size
     */
    public long getFileSize(String path) {
        return new File(path).length();
    }

    /**
     * Gets file uri.
     *
     * @param path the path
     * @return the file uri
     */
    public String getFileURI(String path) {
        return new File(path).toURI().toString();
    }

    /**
     * Generates file with a summary
     *
     * @param inputFilePath  the input file path
     * @param outputFilePath the output file path
     */
    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(outputFilePath)))
        ) {
            printWriter.println(createReport(inputFilePath));
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the summary file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the summary file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with summary file");
            e.printStackTrace();
        }
    }

    /**
     * Creates report of a text file.
     *
     * @param inputFilePath the input file path
     * @return the string
     */
    public String createReport(String inputFilePath) {
        String summaryTemplate = "%-20s%-11s%n%-20s%-11s%n%-20s%-11s%n"
                + "%-20s%-11s%n%-20s%-11s%n%-20s%-11s%n%-20s%-11s%n"
                + "%-20s%-11s%n%-20s%-11s";

        return String.format(summaryTemplate, "Application", "Text file analyzer",
                "Author", "Mike Turchanov",
                "Author email", "mturchanov@madisoncolege.edu",
                "File", getFileAbsolutePath(inputFilePath),
                "Date of analysis", getCurrentTime(),
                "Last modified", getsFileLastModifiedTime(inputFilePath),
                "File Size", getFileSize(inputFilePath),
                "File URI", getFileURI(inputFilePath),
                "Total Tokens", totalTokensCount);
    }
}
