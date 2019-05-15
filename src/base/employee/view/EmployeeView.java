package base.employee.view;

import base.employee.control.EmployeeManager;
import base.employee.exception.EmployeeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeView {

    private static Scanner scanner;
    private static EmployeeManager employeeManager;

    static {
        scanner = new Scanner(System.in);
        employeeManager = EmployeeManager.getInstance();
    }

    public static void login() {
        boolean loggedIn = employeeManager.isLogged();
        while (!loggedIn) {
            try {
                System.out.println("Introduzca su codigo: ");
                int code = scanner.nextInt();

                System.out.println("Introduzca su contraseña: ");
                String password = scanner.next();

                loggedIn = employeeManager.login(code, password);
            } catch (EmployeeException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("Invalid code, only number allowed");
                scanner.next();
            }
        }
    }

    public static void changePassword() {
        System.out.println("Changing password");
        System.out.println("Please enter the new password");
        String newPasswordOne = scanner.next();
        System.out.println("Please confirm you password");
        String newPasswordTwo = scanner.next();
        employeeManager.changePassword(newPasswordOne, newPasswordTwo);
    }
}
