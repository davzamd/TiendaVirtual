package base.employee.control;

import base.employee.domain.Employee;

public class EmployeeManager {

    private static final EmployeeManager instance;
    private static Employee employee;
    private static EmployeeController employeeController;

    private EmployeeManager() {
    }

    static {
        instance = new EmployeeManager();
        employeeController = new EmployeeController();
    }

    public static EmployeeManager getInstance() {
        return instance;
    }

    public boolean isLogged() {
        return employee != null;
    }

    public boolean login(int code, String password) {
        employee = employeeController.authenticateEmployee(code, password);
        if (employee != null) {
            System.out.printf("%n%s %s!", "Bienvenido", employee.getFirstName());
            return true;
        }
        return false;
    }

    public void logout() {
        employee = null;
    }

    public void changePassword(String passwordOne, String passwordTwo) {
        boolean success = false;
        if (passwordOne.equals(passwordTwo)) {
            employee.setPassword(passwordOne);
            success = employeeController.updateEmployees();
        }
        System.out.println(success ? "Password modified successfully!" : "Password didnt modify");
    }

    public String getEmployeeName() {
        return employee.getFirstName();
    }

}
