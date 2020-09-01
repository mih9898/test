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
     * app writes to a file the provided input
     * if two args were provided
     *
     * @param args the input argument that indicates
     * a path file to write
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please enter one argument on the command line,"
                    + " an output file name");
        } else {
            new LabSeven().run(args[0]);
        }
    }

    /**
     * Initialize and set values
     * for the output list
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
     * Writing to a specified file
     * list's values
     *
     * @param outputFilePath the command line argument
     *   that indicates the path for file to write
     */
    public void writeListToOutputFile(String outputFilePath) {
       try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(
               new FileWriter(outputFilePath,true)))) {
           for(String word : list) printWriter.println(word);
       } catch (FileNotFoundException fileNotFoundException) {
           fileNotFoundException.printStackTrace();
       } catch (IOException ioException) {
           ioException.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
       System.out.printf("List data were written to the \"%s\"%n", outputFilePath
               .replaceAll("^.+/", ""));
    }
}
