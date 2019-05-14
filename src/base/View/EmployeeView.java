package base.View;

import base.controller.employee.EmployeeController;
import base.model.employee.domain.Employee;
import base.model.employee.exception.EmployeeException;

import java.util.Scanner;

public class EmployeeView {

    private static Scanner scanner;
    private static EmployeeController employeeController;

    static {
        scanner = new Scanner(System.in);
        employeeController = new EmployeeController();
    }

    public static Employee login() {
        Employee employee = null;
        boolean loggedIn = false;

        while (!loggedIn) {
            try {
                System.out.println("Introduzca su codigo: ");
                int code = scanner.nextInt();

                System.out.println("Introduzca su contraseña: ");
                String password = scanner.next();

                employee = employeeController.authenticateEmployee(code, password);
                loggedIn = true;
            } catch (EmployeeException e) {
                System.out.println(e.getMessage());
            }
        }

        return employee;
    }

    public static void changePassword(Employee employee) {
        boolean success = false;
        System.out.println("Changing password");
        System.out.println("Please enter the new password");
        String newPasswordOne = scanner.next();
        System.out.println("Please confirm you password");
        String newPasswordTwo = scanner.next();
        if (newPasswordOne.equals(newPasswordTwo)) {
            employee.setPassword(newPasswordOne);
            success = employeeController.updateEmployees();
        }
        System.out.println(success ? "Password modified successfully" : "Password didnt modify");
    }
}
