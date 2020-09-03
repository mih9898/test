package java112.labs1;

import java.io.*;
import java.util.*;

/**
 * The app writes to a file set's 
 * sorted values
 *
 * @author mturchanov
 */
public class LabEight {
    private Set<String> uniqueWords;

    /**
     * The entry point of application
     *
     * @param args the input argument that indicates
     * a path file to write
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on"
                    + " the command line, an output file name");
        } else {
            new LabEight().run(args[0]);
        }
    }

    /**
     * Initializes and sets values
     * and writes them to a file
     *
     * @param outputFilePath the command line argument
     *   that indicates the path for a file to write
     */
    public void run(String outputFilePath) {
        String[] strArr = "“one”, “one”, “five”, “two”, “four”, “two”, “three”, “three”, “four”, “three”"
                .replaceAll("[“”\\s]","")
                .split(",");
        uniqueWords = new TreeSet<>(Arrays.asList(strArr));
        writeSetToOutputFile(outputFilePath);
    }

    /**
     * Writes to a specified file
     * sorted set's values
     *
     * @param outputFilePath the command line argument
     * that indicates the path for file to write
     */
    public void writeSetToOutputFile (String outputFilePath) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath,true)))) {
            for(String word : uniqueWords) {
                printWriter.println(word);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file was not found");
            fileNotFoundException.printStackTrace();
            return;
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the file");
            ioException.printStackTrace();
            return;
        } catch (Exception e) {
            System.out.println("There was problem");
            e.printStackTrace();
            return;
        }
        System.out.printf("Set's data were written to the \"%s\"%n", outputFilePath
                .replaceAll("^.+/", ""));
    }
}
