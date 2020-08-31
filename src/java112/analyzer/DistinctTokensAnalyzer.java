package java112.analyzer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 *  create the report of all distinct tokens
 *
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {
    // Only allowed instance variable
    private Set<String> distinctTokens;
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    public static final String OUTPUT_DIST_TOKENS_PATH = "/home/student/GitHubRepos/projects/output/distinct_tokens.txt";


    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    @Override
    public void processToken(String token) {
        for(String str : token.split("\\W")) {
            if(!str.equals("")) distinctTokens.add(str.toLowerCase());
//            if(!str.isEmpty()) {
//                distinctTokens.add(str);
//            }
        }
        System.out.println("unique words: " + distinctTokens.size());
    }

    @Override
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_DIST_TOKENS_PATH, true)))) {
            for(String s : distinctTokens){
                pw.println(s);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
