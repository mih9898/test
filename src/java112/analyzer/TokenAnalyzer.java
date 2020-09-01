package java112.analyzer;

/**
 * This interface analyzes tokens and
 * generate output file
 */
public interface TokenAnalyzer {
    /**
     * Processes token.
     *
     * @param token the token
     */
    void processToken(String token);

    /**
     * Generates output file.
     *
     * @param inputFilePath  the input file path
     * @param outputFilePath the output file path
     */
    void generateOutputFile(String inputFilePath, String outputFilePath);
}
