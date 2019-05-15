package base.product.view;

import base.product.control.ProductManager;

import java.util.InputMismatchException;
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
        System.out.println("\n");
        boolean selected = false;
        do {
            try {
                System.out.println("Que producto desea cambiar? por favor ingrese el codigo");
                int code = scanner.nextInt();
                scanner.nextLine();
                selected = productManager.selectProduct(code);
                if (!selected) {
                    System.out.println("El producto no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Codigo invalido, solo se aceptan numeros");
                scanner.next();
            }
        } while (!selected);
    }

    public static void printModifyMenu() {
        System.out.println("\n");
        System.out.println("1. Modificar nombre de producto");
        System.out.println("2. Modificar precio de producto");
        System.out.println("3. Modificar código de producto");
    }

    public static void modifyName() {
        boolean changed;
        System.out.println("Modificando el nombre del producto " + productManager.getProductName());
        do {
            System.out.println("Por varo ingrese el nuevo nombre");
            String name = scanner.nextLine();

            changed = productManager.changeProductName(name);
        } while (!changed);
    }

    public static void modifyPrice() {
        System.out.println("\n");
        boolean changed = false;
        System.out.println("Modificando el precio del producto: " + productManager.getProductName());
        do {
            try {
                System.out.println("Por favor ingrese el nuevo precio");
                double price = scanner.nextDouble();

                changed = productManager.changeProductPrice(price);
            } catch (InputMismatchException e) {
                System.out.println("Codigo invalido, solo acepta numeros");
                scanner.next();
            }
        } while (!changed);
    }

    public static void modifyCode() {
        System.out.println("\n");
        boolean changed = false;
        System.out.println("Modificando el codigo del producto " + productManager.getProductName());
        do {
            try {
                System.out.println("Por favor ingrese el nuevo codigo");
                int code = scanner.nextInt();

                changed = productManager.changeProductCode(code);
            } catch (InputMismatchException e) {
                System.out.println("Codigo invalido, solo acepta numeros");
                scanner.next();
            }
        } while (!changed);
    }


}
