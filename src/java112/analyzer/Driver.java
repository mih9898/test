package java112.analyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * This program reads a text-file,
 * analyzes its tokens,
 * creates summary-reports on it
 *
 * @author mturchanov
 * @versin 2.0
 */
public class Driver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        FileAnalysis output = new FileAnalysis();
        output.analyze(args);
    }
}
