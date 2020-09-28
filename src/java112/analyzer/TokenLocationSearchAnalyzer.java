package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * Token location search analyzer
 * counts all occurrence of
 * search specified tokens
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer{
    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;

    /**
     * Constructor that initializes {@link #foundLocations}
     */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<>();
    }

    /**
     * Instantiates a new token location search analyzer,
     * initializes {@link #properties},
     * and initializes{@link #foundLocations}
     *
     * @param properties the properties
     */
    public TokenLocationSearchAnalyzer (Properties properties) {
        this();
        this.properties = properties;
        initializeFoundLocations();
    }

    /**
     * Gets found locations
     *
     * @return found locations
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
     * Processes token,
     * counting occurrence
     * of each token's length
     *
     * @param token the token
     */
    @Override
    public void processToken(String token) {
        currentTokenLocation++;
        if (foundLocations.containsKey(token)) {
            foundLocations.get(token).add(currentTokenLocation);
        }
    }

    /**
     * Initializes {@link #foundLocations}
     * with search tokens
     */
    public void initializeFoundLocations() {
        String[] searchTokens = getSearchTokens().split("\\s");
        for(String searchToken : searchTokens) {
            foundLocations.put(searchToken, new ArrayList<>());
        }
    }

    /**
     * Formats list of integers
     *
     * @param locations list with locations
     *                  of specified search tokens
     * @param charactersLimit characters/line limit
     * @return formatted list
     */
    public String formatList(List<Integer> locations, int charactersLimit) {
        charactersLimit++;
        int counter = 0;
        StringBuilder formattedList = new StringBuilder();
        for (String location : locations.toString().split("\\s")){
            counter += location.length() + 1;
            if(counter > charactersLimit) { //reset line
                formattedList.append(System.lineSeparator());
                counter = location.length() + 1;
            }
            formattedList.append(location).append(" ");
        }
        return formattedList.toString()
                .replaceAll("\\s(?=\\n)", "")
                .trim();
    }

    /**
     * Gets search tokens
     * by loading from classpath
     *
     * @return search tokens
     */
    public String getSearchTokens() {
        String fileName = properties.getProperty("classpath.search.tokens");
        StringBuilder searchTokens = new StringBuilder();

        try (InputStream inputStream = this.getClass()
                .getResourceAsStream(fileName);
             BufferedReader searchTokensReader = new BufferedReader(
                     new InputStreamReader(inputStream))) {
            while (searchTokensReader.ready()) {
                String line = searchTokensReader.readLine().trim();
                if(!line.isEmpty()) {
                    searchTokens.append(line).append(" ");
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "search token properties file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " search token properties file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a "
                    + "search token properties file");
            e.printStackTrace();
        }
        return searchTokens.toString();
    }

    /**
     * Generates token lecation search summary
     *
     * @param inputFilePath  the input file path
     */
    @Override
    public void generateOutputFile(String inputFilePath) {
        String summaryOutputPath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.token.search.locations");
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter(summaryOutputPath)))
        ) {
            for (Map.Entry<String, List<Integer>> entry : foundLocations.entrySet()) {
                printWriter.printf("%s =%n%s%n%n",
                        entry.getKey(),
                        formatList(entry.getValue(), 80));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("The file/directory was not found for the "
                    + "token location search file");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("There was problem writing to the"
                    + " token location search file");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("There was problem with a "
                    + "token location search file");
            e.printStackTrace();
        }
    }
}
