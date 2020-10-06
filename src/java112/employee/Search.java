package java112.employee;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Search {
    private String searchType;
    private String searchTerm;
    private List<ResultSet> results;
    private boolean isFound;

    public Search() {}

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<ResultSet> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultSet> results) {
        this.results = results;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public void addFoundEmployee(Employee employee) {
        //TODO: add the employee to the List of found Employee objects

    }
}
