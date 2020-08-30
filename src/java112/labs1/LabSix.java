package java112.labs1;

import java.io.*;

/**
 *
 * The app write to a file
 * from the provided input file,
 * and handle checked exceptions
 * with try-catch
 *
 * @author mturchanov
 *
 */
public class LabSix {
    /**
     *
     * Writing to a specified file
     * provided input
     *
     * @param fileToRead the command line argument
     *   that indicates the path for file to write
     *
     * @param fileToWrite the data to write
     *
     */
    public void run(String fileToRead, String fileToWrite)  {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileToRead)));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileToWrite, true)))
        ) {
            while(br.ready()){
                bw.write(br.readLine());
                bw.write(System.lineSeparator());
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
     *
     * The entry point of application where
     * we write to file the provided input
     * if two args were provided
     *
     * @param args the input argument that indicates
     * a path file to read
     * and a path file to write
     *
     */
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
        } else {
            new LabSix().run(args[0], args[1]);
            System.out.printf("Data from \"%s\" were written to the \"%s\"%n",
                    args[0].replaceAll("^.+/", ""),
                    args[1].replaceAll("^.+/", ""));
        }
    }
}
