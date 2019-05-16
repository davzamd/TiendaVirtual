package base.product.view;

import base.product.control.ProductManager;
import base.util.InputData;

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

    public static void selectProduct() throws IllegalArgumentException {
        System.out.println("\n");
        System.out.println("Que producto desea cambiar? por favor ingrese el codigo");
        int code = InputData.inputInt();
        productManager.selectProduct(code);
    }

    public static void printModifyMenu() {
        System.out.println("\n");
        System.out.println("1. Modificar nombre de producto");
        System.out.println("2. Modificar precio de producto");
        System.out.println("3. Modificar código de producto");
    }

    public static void modifyName() {
        System.out.println("Modificando el nombre del producto " + productManager.getProductName());
        System.out.println("Por varo ingrese el nuevo nombre");

        String name = scanner.nextLine();

        productManager.changeProductName(name);
    }

    public static void modifyPrice() {
        System.out.println("\n");
        System.out.println("Modificando el precio del producto: " + productManager.getProductName());
        System.out.println("Por favor ingrese el nuevo precio");

        double price = InputData.inputDouble();

        productManager.changeProductPrice(price);
    }

    public static void modifyCode() {
        System.out.println("\n");
        System.out.println("Modificando el codigo del producto " + productManager.getProductName());
        System.out.println("Por favor ingrese el nuevo codigo");

        int code = InputData.inputInt();

        productManager.changeProductCode(code);
    }
    


}
