package java112.employee;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains
 * input search terms/types and
 * stores output {@link #results}.
 *
 * @author mturchanov
 */
public class Search {
    private String searchType;
    private String searchTerm;
    private List<Employee> results;
    private boolean isFound;

    /**
     * Instantiates a new Search
     * and initializes {@link #results}
     *
     * @param searchType the search type
     * @param searchTerm the search term
     */
    public Search(String searchType, String searchTerm) {
        this.searchType = searchType;
        this.searchTerm = searchTerm;
        results = new ArrayList<>();
    }

    /**
     * Instantiates a new Search
     * and initializes {@link #results}.
     */
    public Search() { results = new ArrayList<>(); }

    /**
     * Gets search type.
     *
     * @return the search type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Sets search type.
     *
     * @param searchType the search type
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * Gets search term.
     *
     * @return the search term
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets search term.
     *
     * @param searchTerm the search term
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Employee> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(ArrayList<Employee> results) {
        this.results = results;
    }

    /**
     * Is found boolean.
     *
     * @return the boolean
     */
    public boolean isFound() {
        return isFound;
    }

    /**
     * Sets found.
     *
     * @param found the found
     */
    public void setFound(boolean found) {
        isFound = found;
    }

    /**
     * Adds found employee.
     *
     * @param employee the employee
     */
    public void addFoundEmployee(Employee employee) {
        results.add(employee);
    }
}
