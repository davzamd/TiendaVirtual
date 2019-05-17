package base.employee.view;

import base.employee.control.EmployeeManager;
import base.employee.exception.EmployeeException;
import base.util.InputData;
import base.util.OutputData;

public class EmployeeView {

    private static EmployeeManager employeeManager;

    static {
        employeeManager = EmployeeManager.getInstance();
    }

    public static void login() {
        boolean loggedIn = employeeManager.isLogged();
        while (!loggedIn) {
            try {
                System.out.println("\nIntroduzca su codigo: ");
                int code = InputData.inputInt();

                System.out.println("Introduzca su contraseña: ");
                String password = InputData.inputString();

                loggedIn = employeeManager.login(code, password);
            } catch (EmployeeException e) {
                OutputData.printError(e.getMessage());
            }
        }
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
