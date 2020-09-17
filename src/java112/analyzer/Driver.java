package java112.analyzer;


/**
 * This program reads a text-file,
 * analyzes its tokens,
 * creates summary-reports on it
 *
 * @author mturchanov
 * @version 2.0
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
