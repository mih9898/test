package java112.labs1;

import java.io.*;

/**
 * The app makes a copy
 * of a text file
 *
 * @author mturchanov
 */
public class LabSix {
    /**
     * Writes provided input
     * to a specified file
     *
     * @param fileToRead the command line argument
     *   that indicates the path for a file to read
     *
     * @param fileToWrite the file to write
     */
    public void run(String fileToRead, String fileToWrite)  {
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(fileToRead));
                PrintWriter printWriter = new PrintWriter(
                        new BufferedWriter(new FileWriter(fileToWrite)));
        ) {
            while(bufferedReader.ready()){
                printWriter.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file was not found");
            fileNotFoundException.printStackTrace();
            return;
        } catch (IOException ioException) {
            System.out.println("There was problem input/output error");
            ioException.printStackTrace();
            return;
        } catch (Exception e) {
            System.out.println("There was problem");
            e.printStackTrace();
            return;
        }
        System.out.printf("Data from \"%s\" were written to the \"%s\"%n",
                fileToRead.replaceAll("^.+/", ""),
                fileToWrite.replaceAll("^.+/", ""));
    }

    /**
     * The entry point of application where
     *
     * @param args the input argument that indicates
     * a path file to read
     * and a path file to write
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line,"
                    + "an input file name and an output file name");
        } else {
            new LabSix().run(args[0], args[1]);
        }
    }
}
