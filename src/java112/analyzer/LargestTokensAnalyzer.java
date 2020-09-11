package java112.analyzer;

import java.io.*;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class LargestTokensAnalyzer implements TokenAnalyzer {
    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<>();
    }

    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        this.minimumTokenLength = Integer.parseInt
                (properties.getProperty("largest.words.minimum.length"));
    }

    @Override
    public void processToken(String token) {
        if(token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    @Override
    public void generateOutputFile(String inputFilePath) {
        String largestWordsOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.largest.words");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(largestWordsOutputPath)))
        ) {
            for(String word : largestTokens) {
                printWriter.println(word);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "largest tokens file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " largest tokens file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a largest tokens file");
            e.printStackTrace();
        }
    }
}
