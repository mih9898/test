package java112.analyzer;

/**
 * This program reads a text-file,
 * analyzes its unique tokens,
 * creates summary-report on it,
 * creates a list with all unique words
 *
 * @author mturchanov
 * @since 08/31/2020
 */
public class Driver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)  {
        FileAnalysis output = new FileAnalysis();
        output.analyze(args);
    }
}
