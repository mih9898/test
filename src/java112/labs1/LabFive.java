package java112.labs1;

import java.io.*;

/**
 * The app write to a text file
 *
 * @author mturchanov
 */
public class LabFive {

     /**
     * Writes data to a text file
     *
     * @param path the command line argument
     * that indicates the path for file to write
     *
     * @param dataToWrite the data to write
     */
    public void run(String path, String dataToWrite)  {
        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, true)))
        ) {
            bufferedWriter.write(dataToWrite);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application where
     *
     * @param args the input argument that indicates the path for a file
     * and data to write
     */
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
        } else {
            LabFive output = new LabFive();
            output.run(args[0], args[1]);
            System.out.printf("Data were written to the \"%s\"%n", args[0].replaceAll("^.+/", ""));
        }
    }
}
