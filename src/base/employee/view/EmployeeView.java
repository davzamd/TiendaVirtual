package base.employee.view;

import base.employee.control.EmployeeManager;
import base.employee.exception.EmployeeException;
import base.util.InputData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeView {

    private static EmployeeManager employeeManager;

    static {
        employeeManager = EmployeeManager.getInstance();
    }

    public static void login() {
        System.out.println("Introduzca su codigo: ");
        int code = InputData.inputInt();

        System.out.println("Introduzca su contraseña: ");
        String password = InputData.inputString();

        employeeManager.login(code, password);

    }

    public static void changePassword() {
        System.out.println("\nCambiando contraseña");
        System.out.println("Por favor ingrese la nueva contraseña");
        String newPasswordOne = InputData.inputString();
        System.out.println("Por favor vuelva a ingresar la nueva contraseña para confirmar");
        String newPasswordTwo = InputData.inputString();
        employeeManager.changePassword(newPasswordOne, newPasswordTwo);
    }
}
