package base.View;

import base.model.employee.domain.Employee;

import java.util.Scanner;

public class OnlineStore {

    private Employee loggedEmployee;


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (loggedEmployee == null) {
                loggedEmployee = EmployeeView.login();
                System.out.println("Hello " + loggedEmployee.getFirstName());
            }

            printMainMenu();
            int option = scanner.nextInt();
            actionByOption(option);
        }
    }


    public static void printMainMenu() {
        System.out.println("\n1. Hacer pedido");
        System.out.println("2. Modificar un producto");
        System.out.println("3. Cambiar contraseña empleado");
        System.out.println("4. Cerrar sesión");
    }

    private void actionByOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Option 1 selected");
                break;
            case 2:
                System.out.println("Option 2 selected");
                ProductView.modifyProducts();
                break;
            case 3:
                System.out.println("Option 3 selected");
                EmployeeView.changePassword(loggedEmployee);
                break;
            case 4:
                System.out.println("Option 4 selected");
                loggedEmployee = null;
                break;
        }
    }

}
