package java112.analyzer;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{

    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new TreeMap<>();
    }

    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    @Override
    public void processToken(String token) {
        distinctTokenCounts.put(token, distinctTokenCounts.getOrDefault(token, 0) + 1);
    }

    @Override
    public void generateOutputFile(String inputFilePath) {
        String summaryOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.distinct.counts");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(summaryOutputPath)))
        ) {
            for (Map.Entry<String, Integer> entry : distinctTokenCounts.entrySet()) {
                printWriter.printf("%-20s%-11s%n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "distinct counts tokens file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " distinct counts tokens file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a distinct counts tokens file");
            e.printStackTrace();
        }
    }
}
