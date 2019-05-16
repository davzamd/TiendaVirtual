package base.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int getOption(int minOption, int maxOption) {
        boolean goodOption = false;
        int option = 0;
        do {
            try {
                option = scanner.nextInt();
                goodOption = option >= minOption && option <= maxOption;
                if (!goodOption) {
                    System.out.println("Opcion invalida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Codigo invalido, solo acepta numeros");
                scanner.next();
            }
        } while (!goodOption);
        scanner.nextLine();
        return option;
    }

    public static int inputInt() {
        boolean goodResponse = false;
        int response = 0;
        do {
            try {
                response = scanner.nextInt();
                scanner.nextLine();
                goodResponse = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos invalidos, solo se aceptan numeros");
                scanner.next();
            }
        } while (!goodResponse);
        return response;
    }

    public static double inputDouble() {
        boolean goodResponse = false;
        double response = 0;
        do {
            try {
                response = scanner.nextDouble();
                scanner.nextLine();
                goodResponse = true;
            } catch (InputMismatchException e) {
                System.out.println("Datos invalidos, solo se aceptan numeros");
                scanner.next();
            }
        } while (!goodResponse);
        return response;
    }
}
