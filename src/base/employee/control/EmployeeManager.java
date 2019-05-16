package base.employee.control;

import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import base.employee.view.EmployeeView;

import java.util.InputMismatchException;

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

    public void login() {
        do {
            try {
                EmployeeView.login();
            } catch (EmployeeException e) {
                System.out.println(e.getMessage());
            }
        } while (!isLogged());
    }

    public void login(int code, String password) {
        employee = employeeController.authenticateEmployee(code, password);
        if (employee != null) {
            System.out.printf("%n%s %s!%n", "Bienvenido", employee.getFirstName());
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isLogged() {
        return employee != null;
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
