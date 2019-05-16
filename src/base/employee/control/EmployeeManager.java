package base.employee.control;

import base.employee.domain.Employee;
import base.employee.exception.EmployeeException;
import base.employee.view.EmployeeView;
import base.util.Color;

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
        while (!isLogged()) {
            try {
                EmployeeView.login();
            } catch (EmployeeException e) {
                System.out.print(Color.ERROR);
                System.out.println(e.getMessage());
                System.out.print(Color.DEFAULT);
            }
        }
    }

    public void login(int code, String password) {
        employee = employeeController.authenticateEmployee(code, password);
        if (employee != null) {
            System.out.printf("%n%s%s %s%s!%n",
                    Color.SUCCESS, "Bienvenido", Color.DEFAULT, employee.getFirstName());
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
        System.out.println(success ?
                Color.SUCCESS + "Password modified successfully!"
                : Color.ERROR + "Password didnt modify");
        System.out.print(Color.DEFAULT);
    }

    public String getEmployeeName() {
        return employee.getFirstName();
    }

}
