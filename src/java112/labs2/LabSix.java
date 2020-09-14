package java112.labs2;

import java112.utilities.PropertiesLoader;

import java.io.IOException;
import java.util.Properties;

/**
 * This class reads
 * properties and outputs
 * them to the terminal window
 *
 * @author mturchanov
 */
public class LabSix implements PropertiesLoader {
    private Properties properties;

    /**
     * Entry point of the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            LabSix output = new LabSix();
            output.run(args[0]);
        } else {
            System.out.println("Please enter one argument on the command line");
        }

    }

    /**
     * Initializes {@link #properties} with
     * {@link System} properties.
     * Then loads them to {@link #properties} and
     * outputs them to the terminal window
     *
     * @param propertiesFilePath Properties file path
     */
    public void run(String propertiesFilePath) {
        properties = loadProperties(propertiesFilePath);

        for (String key : properties.stringPropertyNames()) {
            System.out.printf("%s=%s%n", key,
                    properties.getProperty(key));
        }
    }
}
