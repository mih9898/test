package java112.employee;

/**
 * This class represents
 * and employee
 *
 * @author mturchanov
 */
public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String ssn;
    private String department;
    private String room;
    private String phone;

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets employee id.
     *
     * @param employeeID the employee id
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets ssn.
     *
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Sets ssn.
     *
     * @param ssn the ssn
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Gets department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department the department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", department='" + department + '\'' +
                ", room='" + room + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
