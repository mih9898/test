package java112.analyzer;

import java112.utilities.PropertiesLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class analyzes a file
 *
 * @author mturchanov
 */
public class FileAnalysis implements PropertiesLoader {
    public static final int VALID_ARG_NUM = 2;
    private List<TokenAnalyzer> analyzers;


    /**
     * Analyzes a file.
     *
     * @param arguments arguments that contains
     * a path to an input file
     */
    public void analyze(String[] arguments) {
        checkArguments(arguments);
        initializeAnalyzers(loadProperties(arguments[1]));
        processAnalyzers(arguments[0]);
        writeOutputFiles(arguments[0]);
        System.out.println("The app finished its work");
    }

    /**
     * Processes analyzers.
     *
     * @param fileToRead the file to read
     */
    public void processAnalyzers(String fileToRead){
        String words = getFileInput(fileToRead);
        TokenAnalyzer lexicalAnalyzer = analyzers.get(analyzers.size() - 1);
        String wordsCopy = words.replaceAll("([,\"]([—-]?-\\w+))|((?<=—-)\\w+)", " bug")
                .replaceAll("—"," ");
//        String wordsCopy = words.replaceAll("([,\"]([—-]?-\\w+))|((?<=—-)?\\r\\n\\w+|\")", " bug")
//                .replaceAll("—"," ");


//        String wordsCopy = words;
        for(String word : words.split("\\W")){
            if (!word.isEmpty()) {
//                passTokensToAnalyzers(word);
            }
        }
        String[] tokens = wordsCopy.split("(?!'|-|’|ï)\\W|_");
        for(int i = 0; i < tokens.length; i++){
            String word = tokens[i];
            if(word.contains("-") || word.contains("—")){
//                System.out.println(word);


//                if(word.matches())
                word = word.replaceAll("-","");
//                        .replaceAll("—"," ");
            }

            if(word.contains("ï")){
                word = word.replaceAll("ï","i");
            }
            if (!word.isEmpty()) {
                if(word.contains("’") ) {
                    word = word.replaceAll("’","'");
                }
//                    System.out.println("123");
//                    word = word.replaceAll("-", "").replaceAll("—", "");
//                }
                lexicalAnalyzer.processToken(word.trim());
            }
        }


//        for(String word : wordsCopy.split("(?!'|-|’|ï|—)\\W|_")) {
////
//            if(word.contains("-") || word.contains("—")){
//                System.out.println(word);
////                if(word.matches())
//                word = word.replaceAll("-","")
//                        .replaceAll("—","");
////            if(functionWords.contains(token.replaceAll("-",""))) lexicalWordsCounter++;
//            }
//
//            if(word.contains("ï")){
//                word = word.replaceAll("ï","i");
//            }
//            if (!word.isEmpty()) {
//                if(word.contains("’") ) {
//                    word = word.replaceAll("’","'");
//                }
////                    System.out.println("123");
////                    word = word.replaceAll("-", "").replaceAll("—", "");
////                }
//                lexicalAnalyzer.processToken(word);
//            }
//        }
    }



    /**
     *
     * @param word
     */
    public void passTokensToAnalyzers(String word) {
        for (TokenAnalyzer analyzer : analyzers) {
            if(!(analyzer instanceof LexicalDensityAnalyzer)){
                analyzer.processToken(word);
            }
        }
    }



    /**
     * Initializes analyzers.
     */
    public void initializeAnalyzers(Properties properties) {
        analyzers = new ArrayList<>();
        analyzers.add(new FileSummaryAnalyzer(properties));
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties));
        analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        analyzers.add(new LexicalDensityAnalyzer(properties));
    }

    /**
     * Writes output to files.
     *
     * @param fileToRead the file to read
     */
    public void writeOutputFiles(String fileToRead){
        for(TokenAnalyzer analyzer : analyzers) {
            analyzer.generateOutputFile(fileToRead);
        }
    }

    /**
     * Checks whether it
     * is one argument passed
     *
     * @param args passed command line arguments
     */
    public void checkArguments(String[] args) {
        if(args.length != VALID_ARG_NUM){
            System.out.println(args.length);
            System.out.println("Please enter the right input to process");
        }
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


