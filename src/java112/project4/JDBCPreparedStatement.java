package java112.project4;

import java.sql.*;

public class JDBCPreparedStatement {
    public void insertEmployees(String id, String firstName, String lastName,
                                String ssn, String department, String room, String phone) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/student", "student", "student");
             PreparedStatement insertEmployee = connection.prepareStatement(
                     "INSERT INTO employees "
                             + "VALUES(?, ?, ?, ?, ?, ?, ?);" );) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            insertEmployee.setInt(1,Integer.parseInt(id));
            insertEmployee.setString(2,firstName);
            insertEmployee.setString(3, lastName);
            insertEmployee.setString(4, ssn);
            insertEmployee.setString(5, department);
            insertEmployee.setString(6, room);
            insertEmployee.setString(7, phone);
            insertEmployee.executeUpdate();
            System.out.printf("Record on %s %s was added%n", firstName, lastName);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    public void insertEmployees(String firstName, String lastName,
                                String ssn, String department, String room, String phone) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/student", "student", "student");
             PreparedStatement insertEmployee = connection.prepareStatement(
                     "INSERT INTO employees(first_name,last_name,ssn,dept,room,phone)"
                             + "VALUES(?, ?, ?, ?, ?, ?);" );) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            insertEmployee.setString(1,firstName);
            insertEmployee.setString(2, lastName);
            insertEmployee.setString(3, ssn);
            insertEmployee.setString(4, department);
            insertEmployee.setString(5, room);
            insertEmployee.setString(6, phone);
            insertEmployee.executeUpdate();
            System.out.printf("Record on %s %s was added%n", firstName, lastName);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    /**
     * The main program for the JDBCInsertEmployee class
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        if(args.length == 7) {
            JDBCPreparedStatement employees = new JDBCPreparedStatement();
            employees.insertEmployees(args[0], args[1], args[2],
                    args[3], args[4], args[5], args[6]);
        } else if(args.length == 6 ){
            JDBCPreparedStatement employees = new JDBCPreparedStatement();
            employees.insertEmployees(args[0], args[1], args[2],
                    args[3], args[4], args[5]);
        } else {
            System.out.println("Please enter appropriate input");
        }
    }
}
