package java112.labs1;

import java.io.*;

/**
 * The app reads a text file 
 * and displays its content
 *
 * @author mturchanov
 */
public class LabFour {
    /**
     * Reads a text file
     * and displays it.
     *
     * @param path the command line argument
     * that indicates the path for to read the file
     */
    public void run(String path)  {
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path)))
        ) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application
     *
     * @param args the input argument that indicates the path for a file
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            LabFour output = new LabFour();
            output.run(args[0]);
        }
    }
}