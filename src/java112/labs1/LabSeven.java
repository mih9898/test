package java112.labs1;

import java.io.*;
import java.util.*;

/**
 * The app writes to a file
 * list values provided by cmd argument
 *
 * @author mturchanov
 */
public class LabSeven {
    private List<String> list;

    /**
     * The entry point of application where
     *
     * @param args the input argument that indicates
     * a path for file to write
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line,"
                    + " an output file name");
        } else {
            new LabSeven().run(args[0]);
        }
    }

    /**
     * Initializes and sets values
     * for the output
     *
     * @param outputFilePath the command line argument
     *   that indicates the path for file to write
     */
    public void run(String outputFilePath) {
        String[] words = "“one”, “two”, “three”, “four”, “five”, “six”, “seven”, “eight”, “nine”, “ten”"
                .replaceAll("[“”\\s]","")
                .split(",");
        list = new ArrayList<>(Arrays.asList(words));
        writeListToOutputFile(outputFilePath);
    }

    /**
     * Writes to a specified file
     * values
     *
     * @param outputFilePath the command line argument
     *   that indicates the path for file to write
     */
    public void writeListToOutputFile(String outputFilePath) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)))) {
            for(String word : list) {
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
        System.out.printf("List data were written to the \"%s\"%n", outputFilePath
                .replaceAll("^.+/", ""));
    }
}
