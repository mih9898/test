package java112.labs1;

import java.io.*;
import java.util.*;

/**
 *
 * The app write to a file
 * set values provided by cmd argument
 *
 * @author mturchanov
 *
 */
public class LabEight {
    private Set<String> set;

    /**
     *
     * The entry point of application where
     * we write to file the provided input
     * if two args were provided
     *
     * @param args the input argument that indicates
     * a path file to write
     *
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please enter one argument on the command line, an output file name");
        } else {
            new LabEight().run(args[0]);
        }
    }

    /**
     *
     * Initialize and set values
     * for the set
     *
     * @param outputFilePath the command line argument
     *   that indicates the path for a file to write
     *
     */
    public void run(String outputFilePath) {
        String[] strArr = "“one”, “one”, “five”, “two”, “four”, “two”, “three”, “three”, “four”, “three”"
                .replaceAll("[“”\\s]","")
                .split(",");
        set = new TreeSet<>(Arrays.asList(strArr));
        writeSetToOutputFile (outputFilePath);
    }

    /**
     *
     * Writing to a specified file
     * set's string values
     *
     * @param outputFilePath the command line argument
     *   that indicates the path for file to write
     *
     */
    public void writeSetToOutputFile (String outputFilePath) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath,true)))) {
            for(String str : set) pw.println(str);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Set's data were written to the \"%s\"%n", outputFilePath
                .replaceAll("^.+/", ""));
    }
}
