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
                    System.out.println("Invalid Option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid code, only number allowed");
                scanner.next();
            }
        } while (!goodOption);
        scanner.nextLine();
        return option;
    }
}
