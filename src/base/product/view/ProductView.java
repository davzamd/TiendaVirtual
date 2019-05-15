package base.product.view;

import base.product.control.ProductManager;

import java.util.Scanner;

public class ProductView {

    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 3;

    private static Scanner scanner;
    private static ProductManager productManager;

    static {
        scanner = new Scanner(System.in);
        productManager = ProductManager.getInstance();
    }

    public static void modifyProducts() {
        printProducts();
        selectProduct();
        printModifyMenu();
        int option = getOption();
        ProductManager.actionByOption(option);
    }

    private static void printProducts() {
        productManager.getProducts().forEach(System.out::println);
    }

    private static void selectProduct() {
        boolean selected;
        do {
            System.out.println("Witch product do you want to change? please enter the code");
            int code = scanner.nextInt();
            scanner.nextLine();
            selected = productManager.selectProduct(code);
            if (!selected) {
                System.out.println("Product doesnt exist");
            }
        } while (!selected);
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

    private static void printModifyMenu() {
        System.out.println("\n1. Modificar nombre de producto");
        System.out.println("2. Modificar precio de producto");
        System.out.println("3. Modificar código de producto\n");
    }


    public static void modifyName() {
        boolean changed;
        System.out.println("Modifying " + productManager.getProductName() + " name's");
        do {
            System.out.println("Please enter the name");
            String name = scanner.nextLine();

            changed = productManager.changeProductName(name);
        } while (!changed);
    }

    public static void modifyPrice() {
        boolean changed;
        System.out.println("Modifying " + productManager.getProductName() + " price");
        do {
            System.out.println("Please enter the new price");
            double price = scanner.nextDouble();

            changed = productManager.changeProductPrice(price);
        } while (!changed);
    }

    public static void modifyCode() {
        boolean changed;
        System.out.println("Modifying " + productManager.getProductName() + " code's");
        do {
            System.out.println("Please enter the code");
            int code = scanner.nextInt();

            changed = productManager.changeProductCode(code);
        } while (!changed);
    }


}
