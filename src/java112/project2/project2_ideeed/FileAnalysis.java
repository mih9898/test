//package java112.project2.project2_ideeed;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
///**
// * This class analyzes a file
// *
// * @author mturchanov
// */
//public class FileAnalysis {
//    public static final int VALID_ARG_NUM = 1;
//    public static final String OUTPUT_SUMMARY_PATH =
//            "output/summary.txt";
//    public static final String OUTPUT_DISTINCT_TOKENS_PATH =
//            "output/distinct_tokens.txt";
//    private DistinctTokensAnalyzer distinctAnalyzer;
//    private FileSummaryAnalyzer summaryAnalyzer;
//
//
//    /**
//     * Analyzes a file.
//     *
//     * @param arguments arguments that contains
//     * a path to an input file
//     */
//    public void analyze(String[] arguments) {
//        checkArguments(arguments);
//        initializeAnalyzers();
//        processAnalyzers(arguments[0]);
//        writeOutputFiles(arguments[0]);
//        System.out.println("The app finished its work");
//    }
//
//    /**
//     * Processes analyzers.
//     *
//     * @param fileToRead the file to read
//     */
//    public void processAnalyzers(String fileToRead){
//        String[] words = getFileInput(fileToRead).split("\\W");
//        for(String word : words){
//            if (!word.isEmpty()) {
//                distinctAnalyzer.processToken(word);
//                summaryAnalyzer.processToken(word);
//            }
//        }
//    }
//
//    /**
//     * Initializes analyzers.
//     */
//    public void initializeAnalyzers() {
//        this.distinctAnalyzer = new DistinctTokensAnalyzer();
//        this.summaryAnalyzer = new FileSummaryAnalyzer();
//    }
//
//    /**
//     * Writes output to files.
//     *
//     * @param fileToRead the file to read
//     */
//    public void writeOutputFiles(String fileToRead){
//        distinctAnalyzer.generateOutputFile(fileToRead, OUTPUT_DISTINCT_TOKENS_PATH);
//        summaryAnalyzer.generateOutputFile(fileToRead, OUTPUT_SUMMARY_PATH);
//    }
//
//    /**
//     * Checks whether it
//     * is one argument passed
//     *
//     * @param arguments passed command line arguments
//     */
//    public void checkArguments(String[] arguments) {
//        if(arguments.length != VALID_ARG_NUM){
//            System.out.println("Please enter the right input to process");
//            System.exit(0);
//        }
//    }
//
//    /**
//     * Gets file input.
//     *
//     * @param path the path
//     * @return the file input
//     */
//    public String getFileInput(String path) {
//        StringBuilder line = new StringBuilder();
//        try (BufferedReader bufferedReader = new BufferedReader(
//                new FileReader(path))
//        ) {
//            while (bufferedReader.ready()){
//                line.append(bufferedReader.readLine()).
//                        append(System.lineSeparator());
//            }
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.out.println("The input file was not found");
//            fileNotFoundException.printStackTrace();
//        } catch (IOException ioException) {
//            System.out.println("There was problem while reading input file");
//            ioException.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("There was problem with input file");
//            e.printStackTrace();
//        }
//        return line.toString();
//    }
//}
//
//
