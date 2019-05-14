package base.model.employee.domain;

public class Employee {

    private int code;
    private String firstName;
    private String lastName;
    private String password;

    public Employee(int code, String firstName, String lastName, String password) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format("%d %s %s %s", code, firstName, lastName, password);
    }
}
