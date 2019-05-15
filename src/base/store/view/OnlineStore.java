package base.store.view;

import base.employee.control.EmployeeManager;
import base.employee.view.EmployeeView;
import base.product.view.ProductView;

import java.util.Scanner;

public class OnlineStore {

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 4;

    private static Scanner scanner;


    static {
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            EmployeeView.login();
            printMainMenu();
            int option = getOption();
            actionByOption(option);
        }
    }


    public static void printMainMenu() {
        System.out.println("\n1. Hacer pedido");
        System.out.println("2. Modificar un producto");
        System.out.println("3. Cambiar contraseña empleado");
        System.out.println("4. Cerrar sesión");
    }

    private static int getOption() {
        boolean goodOption;
        int option;
        do {
            option = scanner.nextInt();
            goodOption = option < MIN_OPTION || option > MAX_OPTION;
            if(!goodOption){
                System.out.println("Invalid Option");
            }
        } while (!goodOption);
        scanner.nextLine();
        return option;
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
                EmployeeView.changePassword();
                break;
            case 4:
                System.out.println("Option 4 selected");
                EmployeeManager.getInstance().logout();
                break;
        }
    }

}
