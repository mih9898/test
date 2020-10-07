package java112.employee;

import java112.utilities.PropertiesLoader;

import java.sql.*;
import java.util.Properties;

public class EmployeeDirectory implements PropertiesLoader {
    private Properties properties;

    public EmployeeDirectory(Properties properties) {
        //TODO: load properties?
        properties = loadProperties("/project4.properties");
        this.properties = properties;
    }

    private Connection establishConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public void addRecord(String employeeID, String firstName, String lastName,
                          String ssn, String department, String room, String phone) {

        try (Connection connection = establishConnection();
             Statement statement = connection.createStatement();) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String insertString = String.format("INSERT INTO employees "
                            + "VALUES(%d, '%s', '%s', '%s', '%s', '%s', '%s');",
                    Integer.parseInt(employeeID), firstName, lastName, ssn, department, room, phone
            );
            statement.executeUpdate(insertString);
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    public Search searchEmployeeDB(String searchTerm, String searchType) {

        return null;
    }


    private void selectEmployee(Search search) {
        try(Connection connection = establishConnection();
            Statement statement = connection.createStatement();) {
            try(ResultSet resultSet = statement.executeQuery(
                    String.format("select * from employee where %s=%s;",
                            search.getSearchType(), search.getSearchTerm()))
            ){
                //Retrieving the data
                if (resultSet.getFetchSize() > 0) {
                    search.setFound(true);
                    while(resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setEmployeeID(Integer.parseInt(resultSet.getString("emp_id")));
                        employee.setFirstName(resultSet.getString("first_name"));
                        employee.setLastName(resultSet.getString("last_name"));
                        employee.setSsn(resultSet.getString("ssn"));
                        employee.setDepartment(resultSet.getString("dept"));
                        employee.setRoom(resultSet.getString("room"));
                        employee.setPhone(resultSet.getString("phone"));
                        search.addFoundEmployee(employee);
                    }
                } else {
                    search.setFound(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    private void searchEmployeeByID(Search search) {
        try(Connection connection = establishConnection();
            Statement statement = connection.createStatement();) {
            try(ResultSet resultSet = statement.executeQuery(
                    //TODO:propper query+
                    "select * from employees where emp_id=" + search.getSearchTerm());){
                //Retrieving the data
                if (resultSet.getFetchSize() > 0) {
                    search.setFound(true);
                    while(resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setEmployeeID(Integer.parseInt(resultSet.getString("emp_id")));
                        employee.setFirstName(resultSet.getString("first_name"));
                        employee.setLastName(resultSet.getString("last_name"));
                        employee.setSsn(resultSet.getString("ssn"));
                        employee.setDepartment(resultSet.getString("dept"));
                        employee.setRoom(resultSet.getString("room"));
                        employee.setPhone(resultSet.getString("phone"));
                        search.addFoundEmployee(employee);
                    }
                } else {
                    search.setFound(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchEmployeeByLastName(Search search) {

    }

    private void searchEmployeeByFirstName(Search search){}

}
