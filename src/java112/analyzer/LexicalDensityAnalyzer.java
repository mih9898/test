package java112.analyzer;

import java.io.*;
import java.util.*;

public class LexicalDensityAnalyzer implements TokenAnalyzer {
        public static Set<String> functionWords;
        private Properties properties;
        private int totalTokensCount;
        private int lexicalWordsCounter;

    public LexicalDensityAnalyzer() {
        functionWords = new HashSet<>();
        loadFunctionWords();
    }

    public LexicalDensityAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    private void loadFunctionWords() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("nonlexical_big_file.txt"))
        ) {
            while (bufferedReader.ready()){
               functionWords.add(bufferedReader.readLine().trim());
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
    }

//46.73%
    @Override
    public void processToken(String token) {
//        System.out.println(token);
        if(token.equals("'") || token.isEmpty()){
            return;
        }
        token = token.replaceAll("-", "")
                .replaceAll("’","'");
//        System.out.println(token);

        if(!functionWords.contains(token.toLowerCase())
                && !token.isEmpty()
                && !isNumber(token)) {
            lexicalWordsCounter++;


//            System.out.println(token);
        }
        totalTokensCount++;
    }

    public boolean isNumber(String str) {
        if(str.matches("0+")){
            return false;
        } else if (str.matches("-?\\d+")
                || str.matches("\\d+\\w+")){
            return true;
        }
        return false;
    }

    @Override
    public void generateOutputFile(String inputFilePath) {
        String summaryOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.lexical.summary");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(summaryOutputPath)))
        ) {
            printWriter.printf("Lexical Summary%nLexical Density is %.2f", (double)lexicalWordsCounter*100 / totalTokensCount);

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
