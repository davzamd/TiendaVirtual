package base.product.view;

import base.product.control.ProductManager;

import java.util.Scanner;

public class ProductView {

    private static Scanner scanner;
    private static ProductManager productManager;

    static {
        scanner = new Scanner(System.in);
        productManager = ProductManager.getInstance();
    }


    public static void printProducts() {
        productManager.getProducts().forEach(System.out::println);
    }

    public static void selectProduct() {
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

    public static void printModifyMenu() {
        System.out.println("1. Modificar nombre de producto");
        System.out.println("2. Modificar precio de producto");
        System.out.println("3. Modificar código de producto");
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
