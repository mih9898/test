package java112.labs2;

import java.io.*;
import java.util.*;

/**
 * This class reads
 * properties and outputs
 * them to the terminal window
 *
 * @author mturchanov
 */
public class LabThree {
    private Properties properties;

    /**
     * Entry point of the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
//        if (args.length == 1) {
//            LabThree output = new LabThree();
//            output.run(args[0]);
//        } else {
//            System.out.println("Please enter one argument on the command line");
//        }
        new LabThree().test();
    }
    public void test(){
        try {
            properties.load(this.getClass().getResourceAsStream("/project2.properties"));
        } catch (IOException ioException) {
            System.out.println("I/O Exception when trying to load properties");
            ioException.printStackTrace();
        }
        for (String key : properties.stringPropertyNames()) {
            System.out.printf("%s=%s%n", key,
                    properties.getProperty(key));
        }
    }

    /**
     * Initializes {@link #properties} with
     * {@link java.lang.System} properties.
     * Then loads them to {@link #properties} and
     * outputs them to the terminal window
     *
     * @param propertiesFilePath Properties file path
     */
    public void run(String propertiesFilePath) {
        loadProperties(propertiesFilePath);
        for (String key : properties.stringPropertyNames()) {
            System.out.printf("%s=%s%n", key,
                    properties.getProperty(key));
        }
    }

    /**
     * Loads the read properties
     * to the {@link #properties}
     *
     * @param propertiesFilePath properties file path
     */
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException|NullPointerException loadError) {
            System.out.println("Can't load the properties file");
            loadError.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }
}
