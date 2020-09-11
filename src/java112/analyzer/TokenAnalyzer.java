package java112.analyzer;

/**
 * This interface analyzes tokens and
 * generates output file
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
     */
    void generateOutputFile(String inputFilePath);
}
