package java112.labs1;

import java.io.*;

/**
 * The app reads the text file,
 * and handle checked exceptions
 * with try-catch
 *
 * @author mturchanov
 *
 */
public class LabFour {
    /**
     *
     * Reading a text file
     * and displaying it.
     *
     * @param path the command line argument
     *   that indicates the path for to read the file
     */
    public void run(String path)  {
        try( BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            while (br.ready()) {
                System.out.println(br.readLine());
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
     * The entry point of application where
     * we output the text file if appropriate
     * argument is provided
     *
     * @param args the input argument that indicates the path for a file
     * @throws IOException the io exception
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            new LabFour().run(args[0]);
        }
    }
}