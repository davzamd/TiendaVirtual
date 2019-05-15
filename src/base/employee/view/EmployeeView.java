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
        System.out.println("\n");
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
                System.out.println("Codigo invalido, solo se aceptan numeros");
                scanner.next();
            }
        }
    }

    public static void changePassword() {
        System.out.println("\n");
        System.out.println("Cambiando contraseña");
        System.out.println("Por favor ingrese la nueva contraseña");
        String newPasswordOne = scanner.next();
        System.out.println("Por favor vuelva a ingresar la nueva contraseña para confirmar");
        String newPasswordTwo = scanner.next();
        employeeManager.changePassword(newPasswordOne, newPasswordTwo);
    }
}
